// $ANTLR 3.5.1 /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g 2018-03-27 21:55:04

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class BahasaBudi2Lexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public BahasaBudi2Lexer() {} 
	public BahasaBudi2Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public BahasaBudi2Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g"; }

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:2:7: ( '(' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:2:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:3:7: ( ')' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:3:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:4:7: ( '*' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:4:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:5:7: ( ',' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:5:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:6:7: ( '=' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:6:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:7:7: ( 'cetak' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:7:9: 'cetak'
			{
			match("cetak"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:8:7: ( 'masukkan' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:8:9: 'masukkan'
			{
			match("masukkan"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:9:7: ( 'var' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:9:9: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:71:5: ( ( '0' .. '9' )+ )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:71:9: ( '0' .. '9' )+
			{
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:71:9: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:72:8: ( ( '\\r' )? '\\n' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:72:9: ( '\\r' )? '\\n'
			{
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:72:9: ( '\\r' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:72:9: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:73:3: ( ( 'a' .. 'z' )+ )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:73:8: ( 'a' .. 'z' )+
			{
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:73:8: ( 'a' .. 'z' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:
					{
					if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:74:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:74:9: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:74:9: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:75:8: ( '\\'' (~ ( '\\'' ) )* '\\'' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:75:11: '\\'' (~ ( '\\'' ) )* '\\''
			{
			match('\''); 
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:75:15: (~ ( '\\'' ) )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\u0000' && LA5_0 <= '&')||(LA5_0 >= '(' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop5;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:76:6: ( '+' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:76:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:77:7: ( '-' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:77:10: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | INT | NEWLINE | ID | WS | STRING | PLUS | MINUS )
		int alt6=15;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt6=1;
			}
			break;
		case ')':
			{
			alt6=2;
			}
			break;
		case '*':
			{
			alt6=3;
			}
			break;
		case ',':
			{
			alt6=4;
			}
			break;
		case '=':
			{
			alt6=5;
			}
			break;
		case 'c':
			{
			int LA6_6 = input.LA(2);
			if ( (LA6_6=='e') ) {
				int LA6_17 = input.LA(3);
				if ( (LA6_17=='t') ) {
					int LA6_21 = input.LA(4);
					if ( (LA6_21=='a') ) {
						int LA6_24 = input.LA(5);
						if ( (LA6_24=='k') ) {
							int LA6_27 = input.LA(6);
							if ( ((LA6_27 >= 'a' && LA6_27 <= 'z')) ) {
								alt6=11;
							}

							else {
								alt6=6;
							}

						}

						else {
							alt6=11;
						}

					}

					else {
						alt6=11;
					}

				}

				else {
					alt6=11;
				}

			}

			else {
				alt6=11;
			}

			}
			break;
		case 'm':
			{
			int LA6_7 = input.LA(2);
			if ( (LA6_7=='a') ) {
				int LA6_18 = input.LA(3);
				if ( (LA6_18=='s') ) {
					int LA6_22 = input.LA(4);
					if ( (LA6_22=='u') ) {
						int LA6_25 = input.LA(5);
						if ( (LA6_25=='k') ) {
							int LA6_28 = input.LA(6);
							if ( (LA6_28=='k') ) {
								int LA6_30 = input.LA(7);
								if ( (LA6_30=='a') ) {
									int LA6_31 = input.LA(8);
									if ( (LA6_31=='n') ) {
										int LA6_32 = input.LA(9);
										if ( ((LA6_32 >= 'a' && LA6_32 <= 'z')) ) {
											alt6=11;
										}

										else {
											alt6=7;
										}

									}

									else {
										alt6=11;
									}

								}

								else {
									alt6=11;
								}

							}

							else {
								alt6=11;
							}

						}

						else {
							alt6=11;
						}

					}

					else {
						alt6=11;
					}

				}

				else {
					alt6=11;
				}

			}

			else {
				alt6=11;
			}

			}
			break;
		case 'v':
			{
			int LA6_8 = input.LA(2);
			if ( (LA6_8=='a') ) {
				int LA6_19 = input.LA(3);
				if ( (LA6_19=='r') ) {
					int LA6_23 = input.LA(4);
					if ( ((LA6_23 >= 'a' && LA6_23 <= 'z')) ) {
						alt6=11;
					}

					else {
						alt6=8;
					}

				}

				else {
					alt6=11;
				}

			}

			else {
				alt6=11;
			}

			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt6=9;
			}
			break;
		case '\r':
			{
			int LA6_10 = input.LA(2);
			if ( (LA6_10=='\n') ) {
				int LA6_11 = input.LA(3);
				if ( ((LA6_11 >= '\t' && LA6_11 <= '\n')||LA6_11=='\r'||LA6_11==' ') ) {
					alt6=12;
				}

				else {
					alt6=10;
				}

			}

			else {
				alt6=12;
			}

			}
			break;
		case '\n':
			{
			int LA6_11 = input.LA(2);
			if ( ((LA6_11 >= '\t' && LA6_11 <= '\n')||LA6_11=='\r'||LA6_11==' ') ) {
				alt6=12;
			}

			else {
				alt6=10;
			}

			}
			break;
		case 'a':
		case 'b':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt6=11;
			}
			break;
		case '\t':
		case ' ':
			{
			alt6=12;
			}
			break;
		case '\'':
			{
			alt6=13;
			}
			break;
		case '+':
			{
			alt6=14;
			}
			break;
		case '-':
			{
			alt6=15;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:10: T__16
				{
				mT__16(); 

				}
				break;
			case 2 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:16: T__17
				{
				mT__17(); 

				}
				break;
			case 3 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:22: T__18
				{
				mT__18(); 

				}
				break;
			case 4 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:28: T__19
				{
				mT__19(); 

				}
				break;
			case 5 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:34: T__20
				{
				mT__20(); 

				}
				break;
			case 6 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:40: T__21
				{
				mT__21(); 

				}
				break;
			case 7 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:46: T__22
				{
				mT__22(); 

				}
				break;
			case 8 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:52: T__23
				{
				mT__23(); 

				}
				break;
			case 9 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:58: INT
				{
				mINT(); 

				}
				break;
			case 10 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:62: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 11 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:70: ID
				{
				mID(); 

				}
				break;
			case 12 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:73: WS
				{
				mWS(); 

				}
				break;
			case 13 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:76: STRING
				{
				mSTRING(); 

				}
				break;
			case 14 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:83: PLUS
				{
				mPLUS(); 

				}
				break;
			case 15 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/BahasaBudi2.g:1:88: MINUS
				{
				mMINUS(); 

				}
				break;

		}
	}



}
