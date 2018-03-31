import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class bahasaBudiLang1 {

	CommonTree root;

	void debug(String message) {
		System.out.println(message);
	}

	bahasaBudiLang1(CommonTree root) {
		this.root = root;
	}
	
	int evaluateExpr(CommonTree expr) {
		debug("Evaluate Expr "+expr.getText());
		if (expr.getType()==bahasaBudi1Lexer.INT) {
			return Integer.parseInt(expr.getText());
		}
		if (expr.getText().equals("+")) {
			return evaluateExpr((CommonTree)expr.getChild(0)) + 
				evaluateExpr((CommonTree)expr.getChild(1));
		}
		if (expr.getText().equals("-")) {
			return evaluateExpr((CommonTree)expr.getChild(0)) - 
				evaluateExpr((CommonTree)expr.getChild(1));
		}
		if (expr.getText().equals("*")) {
			return evaluateExpr((CommonTree)expr.getChild(0)) *
				evaluateExpr((CommonTree)expr.getChild(1));
		}		
		return 0;
	}	

	int evaluateExpression(CommonTree expr) {
		debug("Evaluate Expression "+expr.getText());
		return evaluateExpr((CommonTree)expr.getChild(0));
	}
	
	void evaluateExprList(CommonTree exprlist) {
		debug("Evaluate Expr List");
		for (Object e: exprlist.getChildren()) {
			System.out.println("Result: " + evaluateExpression((CommonTree)e));
		}
	}

	void evaluate() {
		debug("Evaluate");
		evaluateExprList(root);
	}

	public static void main(String argv[]) throws Exception {		
		if (argv.length!=1) {
			System.out.println("Usage: bahasaBudiLang1 <filename.e>");
			return;
		}
		bahasaBudi1Lexer lex = new bahasaBudi1Lexer(new ANTLRFileStream(argv[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		bahasaBudi1Parser g = new bahasaBudi1Parser(tokens);
		bahasaBudi1Parser.prog_return r = g.prog();
		CommonTree ct = (CommonTree)r.getTree();
		bahasaBudiLang1 el = new bahasaBudiLang1(ct);
		el.evaluate();
	}
}
