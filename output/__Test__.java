import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        bahasaBudi1Lexer lex = new bahasaBudi1Lexer(new ANTLRFileStream("/home/c3budiman/Desktop/antlr/bahasaBudi/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        bahasaBudi1Parser g = new bahasaBudi1Parser(tokens, 49100, null);
        try {
            g.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}