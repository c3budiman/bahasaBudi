import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class BulatComp {

	CommonTree root;
	StringBuffer result = new StringBuffer();
	StringBuffer strings = new StringBuffer();
	int strcounter = 0;

	Hashtable<String, Integer> variables = new Hashtable<String, Integer>();

	BulatComp(CommonTree root) {
		this.root = root;
	}

	void checkVar(String var) throws Exception {
		if (!variables.containsKey(var)) {
			throw new Exception("Variable '"+var+"' not declared");
		}
	}
	
	void compileExpr( CommonTree expr) throws Exception{
		if (expr.getType()==BulatLexer.INT) {
			result.append("pushl   $"+expr.getText()+"\n");
			return;
		}
		if (expr.getType()==BulatLexer.ID) {
			checkVar(expr.getText());
			result.append("movl   "+expr.getText()+", %eax\n");
			result.append("pushl  %eax\n");
			return;
		}

		if (expr.getChildCount()==1) {
			if (expr.getText().equals("+")) {
				/*nothing changed*/
				compileExpr((CommonTree)expr.getChild(0));
				return;
			} 
			if (expr.getText().equals("-")) {
				compileExpr((CommonTree)expr.getChild(0));
				result.append("popl   %eax\n");
				result.append("negl   %eax\n");
				result.append("pushl   %eax\n");
				return;
			}
		}
		if (expr.getText().equals("+") || expr.getText().equals("-")
			|| expr.getText().equals("*")) {
			compileExpr((CommonTree)expr.getChild(0));
			compileExpr((CommonTree)expr.getChild(1));
			result.append("popl   %eax\n");
			result.append("popl   %ebx\n");
		}

		if (expr.getText().equals("+")) {
			result.append("addl   %ebx, %eax\n");
		}
		if (expr.getText().equals("-")) {
			result.append("subl   %eax, %ebx\n");
		}
		if (expr.getText().equals("*")) {
			result.append("imull   %ebx, %eax\n");
		}		
		result.append("pushl   %eax\n");
	}	

	void compileDeclaration( CommonTree  decl) {
		result.append(".bss\n");
		for (Object e: decl.getChildren()) {
			CommonTree et = (CommonTree)e;
			String var = et.getText();
			if (!variables.containsKey(var)) {
				result.append(".globl "+ var+"\n");
				result.append(".size  "+var+", 4\n");
				result.append(var+":\n");
				result.append(".zero 4\n");
			}
			variables.put(var, 0);
		}
		result.append(".section	.rodata\n");
		result.append(".print_str_format:\n");
		result.append(".string	\"%s\\n\"\n");
		result.append(".print_int_format:\n");
		result.append(".string	\"%d\\n\"\n");
		result.append(".scan_int_format:\n");
		result.append(".string	\"%d\"\n");
		result.append(".text\n");
		result.append(".globl main\n");
		result.append(".type	main, @function\n");
		result.append("main:\n");
	}

	void compileInput( CommonTree expr) throws Exception {
		String var = expr.getText();
		checkVar(var);
		result.append("pushl   $"+var+"\n");
		result.append("push   $.scan_int_format\n");
		result.append("call   scanf\n");		
		result.append("popl   %ebx\n");
		result.append("popl   %ebx\n");			
	}

	void compilePrint( CommonTree expr) throws Exception {

		if (expr.getType()==BulatLexer.STRING) {
			String s = expr.getText();
			/*remove first ' and last ' from string*/
			s = s.replaceAll("^'", "");
			s = s.replaceAll("'$", "");
			strcounter++;
			strings.append("._str_"+strcounter+":\n");
			strings.append(".string \""+s+"\"\n");								
			result.append("push   $._str_"+strcounter+"\n");
			result.append("push   $.print_str_format\n");
			result.append("call   printf\n");
			result.append("popl   %ebx\n");
			result.append("popl   %ebx\n");
		} else {
			String var = expr.getText();
			checkVar(var);
			result.append("push   "+var+"\n");
			result.append("push   $.print_int_format\n");
			result.append("call   printf\n");
			result.append("popl   %ebx\n");
			result.append("popl   %ebx\n");
		}
	}

	void compileAssignment( CommonTree astmt) throws Exception {
		CommonTree var = (CommonTree)astmt.getChild(0);
		checkVar(var.getText());
		CommonTree expr = (CommonTree)astmt.getChild(1);
		compileExpr(expr);
		result.append("popl %eax\n");
		result.append("movl %eax, "+var.getText()+"\n");
	}

	void compileStatement( CommonTree expr) throws Exception{
		switch (expr.getType()) {
		case BulatLexer.DECLARATION:
			compileDeclaration( expr);
			break;
		case BulatLexer.INPUT:
			compileInput( (CommonTree)expr.getChild(0));
			break;
		case BulatLexer.PRINT:
			compilePrint( (CommonTree)expr.getChild(0));
			break;
		case BulatLexer.ASSIGNMENT:
			compileAssignment( expr);
			break;
		}
	}

	
	void compileStatementList( CommonTree exprlist) throws Exception{
		for (Object e: exprlist.getChildren()) {
			compileStatement( (CommonTree)e);
		}
	}

	String compile() throws Exception {
		compileStatementList( root);
		result.append("ret\n");
		result.append(".size	main, .-main\n");
		result.append(".section	.rodata\n");
		result.append(strings.toString());
		return result.toString();
	}

	public static void main(String argv[]) throws Exception {		
		if (argv.length!=1) {
			System.out.println("Usage: BulatComp <filename.bul>");
			return;
		}
		BulatLexer lex = new BulatLexer(new ANTLRFileStream(argv[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		BulatParser g = new BulatParser(tokens);
		BulatParser.prog_return r = g.prog();
		CommonTree ct = (CommonTree)r.getTree();
		BulatComp el = new BulatComp(ct);
		String result = el.compile();
		String asmname = argv[0] + ".s";
		FileWriter fw = new FileWriter(asmname);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(result);
		fw.close();
		String command[] = {"gcc", "-m32", asmname, "-o", argv[0]+".exe"};
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
	}
}
