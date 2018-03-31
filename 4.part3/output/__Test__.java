import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        BahasaBudi2Lexer lex = new BahasaBudi2Lexer(new ANTLRFileStream("/home/c3budiman/Desktop/antlr/bahasaBudi/4.part3/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        BahasaBudi2Parser g = new BahasaBudi2Parser(tokens, 49100, null);
        try {
            g.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}