// $ANTLR 3.5.1 /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g 2018-03-22 15:34:31

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class bahasaBudi1Lexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public bahasaBudi1Lexer() {} 
	public bahasaBudi1Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public bahasaBudi1Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g"; }

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:2:6: ( '(' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:2:8: '('
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
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:3:7: ( ')' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:3:9: ')'
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:4:7: ( '*' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:4:9: '*'
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:5:7: ( '+' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:5:9: '+'
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:6:7: ( '-' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:6:9: '-'
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
	// $ANTLR end "T__13"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:36:5: ( ( '0' .. '9' )+ )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:36:9: ( '0' .. '9' )+
			{
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:36:9: ( '0' .. '9' )+
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
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:
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
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:37:8: ( ( '\\r' )? '\\n' )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:37:9: ( '\\r' )? '\\n'
			{
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:37:9: ( '\\r' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:37:9: '\\r'
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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:38:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:38:9: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:38:9: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||LA3_0=='\r'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:
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
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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

	@Override
	public void mTokens() throws RecognitionException {
		// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | INT | NEWLINE | WS )
		int alt4=8;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt4=1;
			}
			break;
		case ')':
			{
			alt4=2;
			}
			break;
		case '*':
			{
			alt4=3;
			}
			break;
		case '+':
			{
			alt4=4;
			}
			break;
		case '-':
			{
			alt4=5;
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
			alt4=6;
			}
			break;
		case '\r':
			{
			int LA4_7 = input.LA(2);
			if ( (LA4_7=='\n') ) {
				int LA4_8 = input.LA(3);
				if ( ((LA4_8 >= '\t' && LA4_8 <= '\n')||LA4_8=='\r'||LA4_8==' ') ) {
					alt4=8;
				}

				else {
					alt4=7;
				}

			}

			else {
				alt4=8;
			}

			}
			break;
		case '\n':
			{
			int LA4_8 = input.LA(2);
			if ( ((LA4_8 >= '\t' && LA4_8 <= '\n')||LA4_8=='\r'||LA4_8==' ') ) {
				alt4=8;
			}

			else {
				alt4=7;
			}

			}
			break;
		case '\t':
		case ' ':
			{
			alt4=8;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 4, 0, input);
			throw nvae;
		}
		switch (alt4) {
			case 1 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:10: T__9
				{
				mT__9(); 

				}
				break;
			case 2 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:15: T__10
				{
				mT__10(); 

				}
				break;
			case 3 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:21: T__11
				{
				mT__11(); 

				}
				break;
			case 4 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:27: T__12
				{
				mT__12(); 

				}
				break;
			case 5 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:33: T__13
				{
				mT__13(); 

				}
				break;
			case 6 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:39: INT
				{
				mINT(); 

				}
				break;
			case 7 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:43: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 8 :
				// /home/c3budiman/Desktop/antlr/bahasaBudi/bahasaBudi1.g:1:51: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
