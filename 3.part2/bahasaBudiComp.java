import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class bahasaBudiComp {

	CommonTree root;

	bahasaBudiComp(CommonTree root) {
		this.root = root;
	}

	void compileExpr(StringBuffer result, CommonTree expr) {
		if (expr.getType()==bahasaBudi1Lexer.INT) {
			result.append("pushl   $"+expr.getText()+"\n");
			return;
		}
		if (expr.getText().equals("+") || expr.getText().equals("-")
			|| expr.getText().equals("*")) {
			compileExpr(result, (CommonTree)expr.getChild(0));
			compileExpr(result, (CommonTree)expr.getChild(1));
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

	void compileExpression(StringBuffer result, CommonTree expr) {
		compileExpr(result, (CommonTree)expr.getChild(0));
		result.append("push   $.mytext\n");
		result.append("call   printf\n");
		result.append("popl   %ebx\n");
		result.append("popl   %ebx\n");
	}

	void compileExprList(StringBuffer result, CommonTree exprlist) {
		for (Object e: exprlist.getChildren()) {
			compileExpression(result, (CommonTree)e);
		}
	}

	void compile(StringBuffer result) {
		compileExprList(result, root);
	}

	public static void main(String argv[]) throws Exception {
		if (argv.length!=1) {
			System.out.println("Usage: bahasaBudiComp <filename.e>");
			return;
		}
		bahasaBudi1Lexer lex = new bahasaBudi1Lexer(new ANTLRFileStream(argv[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		bahasaBudi1Parser g = new bahasaBudi1Parser(tokens);
		bahasaBudi1Parser.prog_return r = g.prog();
		CommonTree ct = (CommonTree)r.getTree();
		bahasaBudiComp el = new bahasaBudiComp(ct);
		StringBuffer result = new StringBuffer();
		result.append(".section	.rodata\n");
		result.append(".mytext:\n");
		result.append(".string	\"Result %d\\n\"\n");
		result.append(".text\n");
		result.append(".globl main\n");
		result.append(".type	main, @function\n");
		result.append("main:\n");
		el.compile(result);
		result.append("ret\n");
		result.append(".size	main, .-main\n");
		String asmname = argv[0]+".s";
		FileWriter fw = new FileWriter(asmname);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(result.toString());
		fw.close();
		String command[] = {"gcc", "-m32", asmname, "-o", argv[0]+".exe"};
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
	}
}
