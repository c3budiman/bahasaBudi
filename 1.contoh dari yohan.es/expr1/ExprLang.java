import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class ExprLang {

	CommonTree root;

	void debug(String message) {
		System.out.println(message);
	}

	ExprLang(CommonTree root) {
		this.root = root;
	}
	
	int evaluateExpr(CommonTree expr) {
		debug("Evaluate Expr "+expr.getText());
		if (expr.getType()==ExprLexer.INT) {
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
		return 0; /*fallback, should not happen*/
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
			System.out.println("Usage: ExprLang <filename.e>");
			return;
		}
		ExprLexer lex = new ExprLexer(new ANTLRFileStream(argv[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		ExprParser g = new ExprParser(tokens);
		ExprParser.prog_return r = g.prog();
		CommonTree ct = (CommonTree)r.getTree();
		ExprLang el = new ExprLang(ct);
		el.evaluate();
	}
}
