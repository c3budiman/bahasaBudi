import java.util.Hashtable;
import java.util.Scanner;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class BulatLang {

	CommonTree root;

	Hashtable<String, Integer> variables = new Hashtable<String, Integer>();
	Scanner scanner;

	BulatLang(CommonTree root) {
		this.root = root;
		scanner = new Scanner(System.in);
	}

	void checkVar(String var) throws Exception {
		if (!variables.containsKey(var)) {
			throw new Exception("Variable '"+var+"' not declared");
		}
	}
	
	int evaluateExpr(CommonTree expr) throws Exception{
		if (expr.getType()==BulatLexer.INT) {
			return Integer.parseInt(expr.getText());
		}
		if (expr.getType()==BulatLexer.ID) {
			checkVar(expr.getText());
			return variables.get(expr.getText());
		}
		if (expr.getText().equals("+")) {
			if (expr.getChildCount()==1) {
				return evaluateExpr((CommonTree)expr.getChild(0));
			} else {
				return evaluateExpr((CommonTree)expr.getChild(0)) + 
					evaluateExpr((CommonTree)expr.getChild(1));
			}
		}
		if (expr.getText().equals("-")) {
			if (expr.getChildCount()==1) {
				return -evaluateExpr((CommonTree)expr.getChild(0));
			} else {
				return evaluateExpr((CommonTree)expr.getChild(0)) - 
					evaluateExpr((CommonTree)expr.getChild(1));
			}
		}
		if (expr.getText().equals("*")) {
			return evaluateExpr((CommonTree)expr.getChild(0)) *
				evaluateExpr((CommonTree)expr.getChild(1));
		}		
		return 0; /*fallback, should not happen*/
	}	

	void evaluateDeclaration(CommonTree  decl) {
		for (Object e: decl.getChildren()) {
			CommonTree et = (CommonTree)e;
			variables.put(et.getText(), 0);
		}
	}

	void evaluateInput(CommonTree expr) throws Exception {
		String var = expr.getText();
		checkVar(var);
		int i = scanner.nextInt();
		variables.put(var, i);
	}

	void evaluatePrint(CommonTree expr) throws Exception {
		if (expr.getType()==BulatLexer.STRING) {
			String s = expr.getText();
			/*remove first ' and last ' from string*/
			s = s.replaceAll("^'", "");
			s = s.replaceAll("'$", "");
			System.out.println(s);
		} else {
			String var = expr.getText();
			checkVar(var);
			System.out.println(variables.get(var));
		}
	}

	void evaluateAssignment(CommonTree astmt) throws Exception {
		CommonTree var = (CommonTree)astmt.getChild(0);
		checkVar(var.getText());
		CommonTree expr = (CommonTree)astmt.getChild(1);
		int res = evaluateExpr(expr);
		variables.put(var.getText(), res);
	}

	void evaluateStatement(CommonTree expr) throws Exception{
		switch (expr.getType()) {
		case BulatLexer.DECLARATION:
			evaluateDeclaration(expr);
			break;
		case BulatLexer.INPUT:
			evaluateInput((CommonTree)expr.getChild(0));
			break;
		case BulatLexer.PRINT:
			evaluatePrint((CommonTree)expr.getChild(0));
			break;
		case BulatLexer.ASSIGNMENT:
			evaluateAssignment(expr);
			break;
		}
	}

	
	void evaluateStatementList(CommonTree exprlist) throws Exception{
		for (Object e: exprlist.getChildren()) {
			evaluateStatement((CommonTree)e);
		}
	}

	void evaluate() throws Exception {
		evaluateStatementList(root);
	}

	public static void main(String argv[]) throws Exception {		
		if (argv.length!=1) {
			System.out.println("Usage: BulatLang <filename.e>");
			return;
		}
		BulatLexer lex = new BulatLexer(new ANTLRFileStream(argv[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		BulatParser g = new BulatParser(tokens);
		BulatParser.prog_return r = g.prog();
		CommonTree ct = (CommonTree)r.getTree();
		BulatLang el = new BulatLang(ct);
		el.evaluate();
	}
}
