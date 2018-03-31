// $ANTLR 3.5.1 /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g 2018-03-27 21:55:04

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class BahasaBudi2Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "DECLARATION", "ID", 
		"INPUT", "INT", "MINUS", "NEWLINE", "PLUS", "PRINT", "STATEMENT_LIST", 
		"STRING", "WS", "'('", "')'", "'*'", "','", "'='", "'cetak'", "'masukkan'", 
		"'var'"
	};
	public static final int EOF=-1;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int ASSIGNMENT=4;
	public static final int DECLARATION=5;
	public static final int ID=6;
	public static final int INPUT=7;
	public static final int INT=8;
	public static final int MINUS=9;
	public static final int NEWLINE=10;
	public static final int PLUS=11;
	public static final int PRINT=12;
	public static final int STATEMENT_LIST=13;
	public static final int STRING=14;
	public static final int WS=15;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public BahasaBudi2Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public BahasaBudi2Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return BahasaBudi2Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g"; }


	public static class prog_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:20:1: prog : declaration ( stat )+ -> ^( STATEMENT_LIST declaration ( stat )+ ) ;
	public final BahasaBudi2Parser.prog_return prog() throws RecognitionException {
		BahasaBudi2Parser.prog_return retval = new BahasaBudi2Parser.prog_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope declaration1 =null;
		ParserRuleReturnScope stat2 =null;

		RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
		RewriteRuleSubtreeStream stream_declaration=new RewriteRuleSubtreeStream(adaptor,"rule declaration");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:20:5: ( declaration ( stat )+ -> ^( STATEMENT_LIST declaration ( stat )+ ) )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:20:9: declaration ( stat )+
			{
			pushFollow(FOLLOW_declaration_in_prog72);
			declaration1=declaration();
			state._fsp--;

			stream_declaration.add(declaration1.getTree());
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:20:21: ( stat )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID||LA1_0==NEWLINE||(LA1_0 >= 21 && LA1_0 <= 22)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:20:21: stat
					{
					pushFollow(FOLLOW_stat_in_prog74);
					stat2=stat();
					state._fsp--;

					stream_stat.add(stat2.getTree());
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
			// elements: declaration, stat
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 20:27: -> ^( STATEMENT_LIST declaration ( stat )+ )
			{
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:20:30: ^( STATEMENT_LIST declaration ( stat )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STATEMENT_LIST, "STATEMENT_LIST"), root_1);
				adaptor.addChild(root_1, stream_declaration.nextTree());
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
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:22:1: stat : ( assignment NEWLINE -> assignment | input NEWLINE -> input | print NEWLINE -> print | NEWLINE );
	public final BahasaBudi2Parser.stat_return stat() throws RecognitionException {
		BahasaBudi2Parser.stat_return retval = new BahasaBudi2Parser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NEWLINE4=null;
		Token NEWLINE6=null;
		Token NEWLINE8=null;
		Token NEWLINE9=null;
		ParserRuleReturnScope assignment3 =null;
		ParserRuleReturnScope input5 =null;
		ParserRuleReturnScope print7 =null;

		CommonTree NEWLINE4_tree=null;
		CommonTree NEWLINE6_tree=null;
		CommonTree NEWLINE8_tree=null;
		CommonTree NEWLINE9_tree=null;
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_print=new RewriteRuleSubtreeStream(adaptor,"rule print");
		RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:22:5: ( assignment NEWLINE -> assignment | input NEWLINE -> input | print NEWLINE -> print | NEWLINE )
			int alt2=4;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt2=1;
				}
				break;
			case 22:
				{
				alt2=2;
				}
				break;
			case 21:
				{
				alt2=3;
				}
				break;
			case NEWLINE:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:22:9: assignment NEWLINE
					{
					pushFollow(FOLLOW_assignment_in_stat95);
					assignment3=assignment();
					state._fsp--;

					stream_assignment.add(assignment3.getTree());
					NEWLINE4=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat97);  
					stream_NEWLINE.add(NEWLINE4);

					// AST REWRITE
					// elements: assignment
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 22:28: -> assignment
					{
						adaptor.addChild(root_0, stream_assignment.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:23:7: input NEWLINE
					{
					pushFollow(FOLLOW_input_in_stat109);
					input5=input();
					state._fsp--;

					stream_input.add(input5.getTree());
					NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat111);  
					stream_NEWLINE.add(NEWLINE6);

					// AST REWRITE
					// elements: input
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 23:21: -> input
					{
						adaptor.addChild(root_0, stream_input.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:24:7: print NEWLINE
					{
					pushFollow(FOLLOW_print_in_stat123);
					print7=print();
					state._fsp--;

					stream_print.add(print7.getTree());
					NEWLINE8=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat125);  
					stream_NEWLINE.add(NEWLINE8);

					// AST REWRITE
					// elements: print
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 24:21: -> print
					{
						adaptor.addChild(root_0, stream_print.nextTree());
					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:25:7: NEWLINE
					{
					root_0 = (CommonTree)adaptor.nil();


					NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat136); 
					NEWLINE9_tree = (CommonTree)adaptor.create(NEWLINE9);
					adaptor.addChild(root_0, NEWLINE9_tree);

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


	public static class declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:29:1: declaration : 'var' ID ( ',' ID )* NEWLINE -> ^( DECLARATION ( ID )* ) ;
	public final BahasaBudi2Parser.declaration_return declaration() throws RecognitionException {
		BahasaBudi2Parser.declaration_return retval = new BahasaBudi2Parser.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal10=null;
		Token ID11=null;
		Token char_literal12=null;
		Token ID13=null;
		Token NEWLINE14=null;

		CommonTree string_literal10_tree=null;
		CommonTree ID11_tree=null;
		CommonTree char_literal12_tree=null;
		CommonTree ID13_tree=null;
		CommonTree NEWLINE14_tree=null;
		RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleTokenStream stream_19=new RewriteRuleTokenStream(adaptor,"token 19");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:30:2: ( 'var' ID ( ',' ID )* NEWLINE -> ^( DECLARATION ( ID )* ) )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:31:2: 'var' ID ( ',' ID )* NEWLINE
			{
			string_literal10=(Token)match(input,23,FOLLOW_23_in_declaration153);  
			stream_23.add(string_literal10);

			ID11=(Token)match(input,ID,FOLLOW_ID_in_declaration155);  
			stream_ID.add(ID11);

			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:31:11: ( ',' ID )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==19) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:31:13: ',' ID
					{
					char_literal12=(Token)match(input,19,FOLLOW_19_in_declaration159);  
					stream_19.add(char_literal12);

					ID13=(Token)match(input,ID,FOLLOW_ID_in_declaration161);  
					stream_ID.add(ID13);

					}
					break;

				default :
					break loop3;
				}
			}

			NEWLINE14=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_declaration165);  
			stream_NEWLINE.add(NEWLINE14);

			// AST REWRITE
			// elements: ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 31:30: -> ^( DECLARATION ( ID )* )
			{
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:31:33: ^( DECLARATION ( ID )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLARATION, "DECLARATION"), root_1);
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:31:47: ( ID )*
				while ( stream_ID.hasNext() ) {
					adaptor.addChild(root_1, stream_ID.nextNode());
				}
				stream_ID.reset();

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
	// $ANTLR end "declaration"


	public static class input_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "input"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:33:1: input : 'masukkan' ID -> ^( INPUT ID ) ;
	public final BahasaBudi2Parser.input_return input() throws RecognitionException {
		BahasaBudi2Parser.input_return retval = new BahasaBudi2Parser.input_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal15=null;
		Token ID16=null;

		CommonTree string_literal15_tree=null;
		CommonTree ID16_tree=null;
		RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:33:7: ( 'masukkan' ID -> ^( INPUT ID ) )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:34:2: 'masukkan' ID
			{
			string_literal15=(Token)match(input,22,FOLLOW_22_in_input185);  
			stream_22.add(string_literal15);

			ID16=(Token)match(input,ID,FOLLOW_ID_in_input187);  
			stream_ID.add(ID16);

			// AST REWRITE
			// elements: ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 34:16: -> ^( INPUT ID )
			{
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:34:19: ^( INPUT ID )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INPUT, "INPUT"), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
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
	// $ANTLR end "input"


	public static class print_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "print"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:36:1: print : ( 'cetak' ID -> ^( PRINT ID ) | 'cetak' STRING -> ^( PRINT STRING ) );
	public final BahasaBudi2Parser.print_return print() throws RecognitionException {
		BahasaBudi2Parser.print_return retval = new BahasaBudi2Parser.print_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal17=null;
		Token ID18=null;
		Token string_literal19=null;
		Token STRING20=null;

		CommonTree string_literal17_tree=null;
		CommonTree ID18_tree=null;
		CommonTree string_literal19_tree=null;
		CommonTree STRING20_tree=null;
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:36:9: ( 'cetak' ID -> ^( PRINT ID ) | 'cetak' STRING -> ^( PRINT STRING ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==21) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==ID) ) {
					alt4=1;
				}
				else if ( (LA4_1==STRING) ) {
					alt4=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:37:2: 'cetak' ID
					{
					string_literal17=(Token)match(input,21,FOLLOW_21_in_print208);  
					stream_21.add(string_literal17);

					ID18=(Token)match(input,ID,FOLLOW_ID_in_print210);  
					stream_ID.add(ID18);

					// AST REWRITE
					// elements: ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 37:13: -> ^( PRINT ID )
					{
						// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:37:16: ^( PRINT ID )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PRINT, "PRINT"), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:38:4: 'cetak' STRING
					{
					string_literal19=(Token)match(input,21,FOLLOW_21_in_print223);  
					stream_21.add(string_literal19);

					STRING20=(Token)match(input,STRING,FOLLOW_STRING_in_print225);  
					stream_STRING.add(STRING20);

					// AST REWRITE
					// elements: STRING
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 38:19: -> ^( PRINT STRING )
					{
						// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:38:22: ^( PRINT STRING )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PRINT, "PRINT"), root_1);
						adaptor.addChild(root_1, stream_STRING.nextNode());
						adaptor.addChild(root_0, root_1);
						}

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
	// $ANTLR end "print"


	public static class assignment_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:41:1: assignment : ID '=' expr -> ^( ASSIGNMENT ID expr ) ;
	public final BahasaBudi2Parser.assignment_return assignment() throws RecognitionException {
		BahasaBudi2Parser.assignment_return retval = new BahasaBudi2Parser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID21=null;
		Token char_literal22=null;
		ParserRuleReturnScope expr23 =null;

		CommonTree ID21_tree=null;
		CommonTree char_literal22_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:42:2: ( ID '=' expr -> ^( ASSIGNMENT ID expr ) )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:43:2: ID '=' expr
			{
			ID21=(Token)match(input,ID,FOLLOW_ID_in_assignment248);  
			stream_ID.add(ID21);

			char_literal22=(Token)match(input,20,FOLLOW_20_in_assignment250);  
			stream_20.add(char_literal22);

			pushFollow(FOLLOW_expr_in_assignment252);
			expr23=expr();
			state._fsp--;

			stream_expr.add(expr23.getTree());
			// AST REWRITE
			// elements: expr, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 43:14: -> ^( ASSIGNMENT ID expr )
			{
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:43:17: ^( ASSIGNMENT ID expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
				adaptor.addChild(root_1, stream_expr.nextTree());
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
	// $ANTLR end "assignment"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:46:1: expr : multExpr ( ( '+' | '-' ) ^ multExpr )* ;
	public final BahasaBudi2Parser.expr_return expr() throws RecognitionException {
		BahasaBudi2Parser.expr_return retval = new BahasaBudi2Parser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set25=null;
		ParserRuleReturnScope multExpr24 =null;
		ParserRuleReturnScope multExpr26 =null;

		CommonTree set25_tree=null;

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:46:5: ( multExpr ( ( '+' | '-' ) ^ multExpr )* )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:46:9: multExpr ( ( '+' | '-' ) ^ multExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_multExpr_in_expr273);
			multExpr24=multExpr();
			state._fsp--;

			adaptor.addChild(root_0, multExpr24.getTree());

			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:46:18: ( ( '+' | '-' ) ^ multExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==MINUS||LA5_0==PLUS) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:46:19: ( '+' | '-' ) ^ multExpr
					{
					set25=input.LT(1);
					set25=input.LT(1);
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set25), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr283);
					multExpr26=multExpr();
					state._fsp--;

					adaptor.addChild(root_0, multExpr26.getTree());

					}
					break;

				default :
					break loop5;
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
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:49:1: multExpr : unaryExpr ( '*' ^ unaryExpr )* ;
	public final BahasaBudi2Parser.multExpr_return multExpr() throws RecognitionException {
		BahasaBudi2Parser.multExpr_return retval = new BahasaBudi2Parser.multExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal28=null;
		ParserRuleReturnScope unaryExpr27 =null;
		ParserRuleReturnScope unaryExpr29 =null;

		CommonTree char_literal28_tree=null;

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:50:5: ( unaryExpr ( '*' ^ unaryExpr )* )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:50:9: unaryExpr ( '*' ^ unaryExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_unaryExpr_in_multExpr305);
			unaryExpr27=unaryExpr();
			state._fsp--;

			adaptor.addChild(root_0, unaryExpr27.getTree());

			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:50:19: ( '*' ^ unaryExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==18) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:50:20: '*' ^ unaryExpr
					{
					char_literal28=(Token)match(input,18,FOLLOW_18_in_multExpr308); 
					char_literal28_tree = (CommonTree)adaptor.create(char_literal28);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal28_tree, root_0);

					pushFollow(FOLLOW_unaryExpr_in_multExpr311);
					unaryExpr29=unaryExpr();
					state._fsp--;

					adaptor.addChild(root_0, unaryExpr29.getTree());

					}
					break;

				default :
					break loop6;
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


	public static class unaryExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unaryExpr"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:53:1: unaryExpr : ( unary_op ^ atom | atom );
	public final BahasaBudi2Parser.unaryExpr_return unaryExpr() throws RecognitionException {
		BahasaBudi2Parser.unaryExpr_return retval = new BahasaBudi2Parser.unaryExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope unary_op30 =null;
		ParserRuleReturnScope atom31 =null;
		ParserRuleReturnScope atom32 =null;


		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:54:2: ( unary_op ^ atom | atom )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==MINUS||LA7_0==PLUS) ) {
				alt7=1;
			}
			else if ( (LA7_0==ID||LA7_0==INT||LA7_0==16) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:54:4: unary_op ^ atom
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_unary_op_in_unaryExpr331);
					unary_op30=unary_op();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(unary_op30.getTree(), root_0);
					pushFollow(FOLLOW_atom_in_unaryExpr334);
					atom31=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom31.getTree());

					}
					break;
				case 2 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:55:4: atom
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_atom_in_unaryExpr339);
					atom32=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom32.getTree());

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
	// $ANTLR end "unaryExpr"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:58:1: atom : ( INT | ID | '(' expr ')' -> expr );
	public final BahasaBudi2Parser.atom_return atom() throws RecognitionException {
		BahasaBudi2Parser.atom_return retval = new BahasaBudi2Parser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT33=null;
		Token ID34=null;
		Token char_literal35=null;
		Token char_literal37=null;
		ParserRuleReturnScope expr36 =null;

		CommonTree INT33_tree=null;
		CommonTree ID34_tree=null;
		CommonTree char_literal35_tree=null;
		CommonTree char_literal37_tree=null;
		RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
		RewriteRuleTokenStream stream_17=new RewriteRuleTokenStream(adaptor,"token 17");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:58:5: ( INT | ID | '(' expr ')' -> expr )
			int alt8=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt8=1;
				}
				break;
			case ID:
				{
				alt8=2;
				}
				break;
			case 16:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:58:9: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					INT33=(Token)match(input,INT,FOLLOW_INT_in_atom354); 
					INT33_tree = (CommonTree)adaptor.create(INT33);
					adaptor.addChild(root_0, INT33_tree);

					}
					break;
				case 2 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:59:7: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID34=(Token)match(input,ID,FOLLOW_ID_in_atom363); 
					ID34_tree = (CommonTree)adaptor.create(ID34);
					adaptor.addChild(root_0, ID34_tree);

					}
					break;
				case 3 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:60:9: '(' expr ')'
					{
					char_literal35=(Token)match(input,16,FOLLOW_16_in_atom373);  
					stream_16.add(char_literal35);

					pushFollow(FOLLOW_expr_in_atom375);
					expr36=expr();
					state._fsp--;

					stream_expr.add(expr36.getTree());
					char_literal37=(Token)match(input,17,FOLLOW_17_in_atom377);  
					stream_17.add(char_literal37);

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
					// 60:22: -> expr
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


	public static class unary_op_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unary_op"
	// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:63:1: unary_op : ( PLUS | MINUS );
	public final BahasaBudi2Parser.unary_op_return unary_op() throws RecognitionException {
		BahasaBudi2Parser.unary_op_return retval = new BahasaBudi2Parser.unary_op_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set38=null;

		CommonTree set38_tree=null;

		try {
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:63:9: ( PLUS | MINUS )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set38=input.LT(1);
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set38));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
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
	// $ANTLR end "unary_op"

	// Delegated rules



	public static final BitSet FOLLOW_declaration_in_prog72 = new BitSet(new long[]{0x0000000000600440L});
	public static final BitSet FOLLOW_stat_in_prog74 = new BitSet(new long[]{0x0000000000600442L});
	public static final BitSet FOLLOW_assignment_in_stat95 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_NEWLINE_in_stat97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_input_in_stat109 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_NEWLINE_in_stat111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_in_stat123 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_NEWLINE_in_stat125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_declaration153 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_declaration155 = new BitSet(new long[]{0x0000000000080400L});
	public static final BitSet FOLLOW_19_in_declaration159 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_declaration161 = new BitSet(new long[]{0x0000000000080400L});
	public static final BitSet FOLLOW_NEWLINE_in_declaration165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_input185 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_input187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_print208 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_print210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_print223 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_STRING_in_print225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignment248 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_assignment250 = new BitSet(new long[]{0x0000000000010B40L});
	public static final BitSet FOLLOW_expr_in_assignment252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr273 = new BitSet(new long[]{0x0000000000000A02L});
	public static final BitSet FOLLOW_set_in_expr276 = new BitSet(new long[]{0x0000000000010B40L});
	public static final BitSet FOLLOW_multExpr_in_expr283 = new BitSet(new long[]{0x0000000000000A02L});
	public static final BitSet FOLLOW_unaryExpr_in_multExpr305 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_multExpr308 = new BitSet(new long[]{0x0000000000010B40L});
	public static final BitSet FOLLOW_unaryExpr_in_multExpr311 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_unary_op_in_unaryExpr331 = new BitSet(new long[]{0x0000000000010140L});
	public static final BitSet FOLLOW_atom_in_unaryExpr334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unaryExpr339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_atom354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_atom373 = new BitSet(new long[]{0x0000000000010B40L});
	public static final BitSet FOLLOW_expr_in_atom375 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_atom377 = new BitSet(new long[]{0x0000000000000002L});
}
