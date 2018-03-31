// $ANTLR 3.5.1 /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g 2018-03-22 15:34:31

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class bahasaBudi1Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "EXPRESSION", "EXPRESSION_LIST", 
		"INT", "NEWLINE", "WS", "'('", "')'", "'*'", "'+'", "'-'"
	};
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int EXPRESSION=4;
	public static final int EXPRESSION_LIST=5;
	public static final int INT=6;
	public static final int NEWLINE=7;
	public static final int WS=8;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public bahasaBudi1Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public bahasaBudi1Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return bahasaBudi1Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g"; }


	public static class prog_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:15:1: prog : ( stat )+ -> ^( EXPRESSION_LIST ( stat )+ ) ;
	public final bahasaBudi1Parser.prog_return prog() throws RecognitionException {
		bahasaBudi1Parser.prog_return retval = new bahasaBudi1Parser.prog_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat1 =null;

		RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:15:5: ( ( stat )+ -> ^( EXPRESSION_LIST ( stat )+ ) )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:15:9: ( stat )+
			{
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:15:9: ( stat )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= INT && LA1_0 <= NEWLINE)||LA1_0==9) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:15:9: stat
					{
					pushFollow(FOLLOW_stat_in_prog49);
					stat1=stat();
					state._fsp--;

					stream_stat.add(stat1.getTree());
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			// AST REWRITE
			// elements: stat
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 15:15: -> ^( EXPRESSION_LIST ( stat )+ )
			{
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:15:18: ^( EXPRESSION_LIST ( stat )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESSION_LIST, "EXPRESSION_LIST"), root_1);
				if ( !(stream_stat.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_stat.hasNext() ) {
					adaptor.addChild(root_1, stream_stat.nextTree());
				}
				stream_stat.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "prog"


	public static class stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:17:1: stat : ( expr NEWLINE -> ^( EXPRESSION expr ) | NEWLINE );
	public final bahasaBudi1Parser.stat_return stat() throws RecognitionException {
		bahasaBudi1Parser.stat_return retval = new bahasaBudi1Parser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NEWLINE3=null;
		Token NEWLINE4=null;
		ParserRuleReturnScope expr2 =null;

		CommonTree NEWLINE3_tree=null;
		CommonTree NEWLINE4_tree=null;
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:17:5: ( expr NEWLINE -> ^( EXPRESSION expr ) | NEWLINE )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==INT||LA2_0==9) ) {
				alt2=1;
			}
			else if ( (LA2_0==NEWLINE) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:17:9: expr NEWLINE
					{
					pushFollow(FOLLOW_expr_in_stat68);
					expr2=expr();
					state._fsp--;

					stream_expr.add(expr2.getTree());
					NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat70);  
					stream_NEWLINE.add(NEWLINE3);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 17:22: -> ^( EXPRESSION expr )
					{
						// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:17:25: ^( EXPRESSION expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:18:9: NEWLINE
					{
					root_0 = (CommonTree)adaptor.nil();


					NEWLINE4=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat88); 
					NEWLINE4_tree = (CommonTree)adaptor.create(NEWLINE4);
					adaptor.addChild(root_0, NEWLINE4_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stat"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:23:1: expr : multExpr ( ( '+' | '-' ) ^ multExpr )* ;
	public final bahasaBudi1Parser.expr_return expr() throws RecognitionException {
		bahasaBudi1Parser.expr_return retval = new bahasaBudi1Parser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set6=null;
		ParserRuleReturnScope multExpr5 =null;
		ParserRuleReturnScope multExpr7 =null;

		CommonTree set6_tree=null;

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:23:5: ( multExpr ( ( '+' | '-' ) ^ multExpr )* )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:23:9: multExpr ( ( '+' | '-' ) ^ multExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_multExpr_in_expr104);
			multExpr5=multExpr();
			state._fsp--;

			adaptor.addChild(root_0, multExpr5.getTree());

			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:23:18: ( ( '+' | '-' ) ^ multExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= 12 && LA3_0 <= 13)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:23:19: ( '+' | '-' ) ^ multExpr
					{
					set6=input.LT(1);
					set6=input.LT(1);
					if ( (input.LA(1) >= 12 && input.LA(1) <= 13) ) {
						input.consume();
						root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set6), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr114);
					multExpr7=multExpr();
					state._fsp--;

					adaptor.addChild(root_0, multExpr7.getTree());

					}
					break;

				default :
					break loop3;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class multExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "multExpr"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:26:1: multExpr : atom ( '*' ^ atom )* ;
	public final bahasaBudi1Parser.multExpr_return multExpr() throws RecognitionException {
		bahasaBudi1Parser.multExpr_return retval = new bahasaBudi1Parser.multExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal9=null;
		ParserRuleReturnScope atom8 =null;
		ParserRuleReturnScope atom10 =null;

		CommonTree char_literal9_tree=null;

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:27:5: ( atom ( '*' ^ atom )* )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:27:9: atom ( '*' ^ atom )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_atom_in_multExpr136);
			atom8=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom8.getTree());

			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:27:14: ( '*' ^ atom )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==11) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:27:15: '*' ^ atom
					{
					char_literal9=(Token)match(input,11,FOLLOW_11_in_multExpr139); 
					char_literal9_tree = (CommonTree)adaptor.create(char_literal9);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal9_tree, root_0);

					pushFollow(FOLLOW_atom_in_multExpr142);
					atom10=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom10.getTree());

					}
					break;

				default :
					break loop4;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:30:1: atom : ( INT | '(' expr ')' -> expr );
	public final bahasaBudi1Parser.atom_return atom() throws RecognitionException {
		bahasaBudi1Parser.atom_return retval = new bahasaBudi1Parser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT11=null;
		Token char_literal12=null;
		Token char_literal14=null;
		ParserRuleReturnScope expr13 =null;

		CommonTree INT11_tree=null;
		CommonTree char_literal12_tree=null;
		CommonTree char_literal14_tree=null;
		RewriteRuleTokenStream stream_9=new RewriteRuleTokenStream(adaptor,"token 9");
		RewriteRuleTokenStream stream_10=new RewriteRuleTokenStream(adaptor,"token 10");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:30:5: ( INT | '(' expr ')' -> expr )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==INT) ) {
				alt5=1;
			}
			else if ( (LA5_0==9) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:30:9: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					INT11=(Token)match(input,INT,FOLLOW_INT_in_atom159); 
					INT11_tree = (CommonTree)adaptor.create(INT11);
					adaptor.addChild(root_0, INT11_tree);

					}
					break;
				case 2 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:31:9: '(' expr ')'
					{
					char_literal12=(Token)match(input,9,FOLLOW_9_in_atom170);  
					stream_9.add(char_literal12);

					pushFollow(FOLLOW_expr_in_atom172);
					expr13=expr();
					state._fsp--;

					stream_expr.add(expr13.getTree());
					char_literal14=(Token)match(input,10,FOLLOW_10_in_atom174);  
					stream_10.add(char_literal14);

					// AST REWRITE
					// elements: expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 31:22: -> expr
					{
						adaptor.addChild(root_0, stream_expr.nextTree());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog49 = new BitSet(new long[]{0x00000000000002C2L});
	public static final BitSet FOLLOW_expr_in_stat68 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NEWLINE_in_stat70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr104 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_set_in_expr107 = new BitSet(new long[]{0x0000000000000240L});
	public static final BitSet FOLLOW_multExpr_in_expr114 = new BitSet(new long[]{0x0000000000003002L});
	public static final BitSet FOLLOW_atom_in_multExpr136 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_11_in_multExpr139 = new BitSet(new long[]{0x0000000000000240L});
	public static final BitSet FOLLOW_atom_in_multExpr142 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_INT_in_atom159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_atom170 = new BitSet(new long[]{0x0000000000000240L});
	public static final BitSet FOLLOW_expr_in_atom172 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_atom174 = new BitSet(new long[]{0x0000000000000002L});
}
