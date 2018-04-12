import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class BudiComp {

	CommonTree root;
	StringBuffer result = new StringBuffer();
	StringBuffer strings = new StringBuffer();
	int strcounter = 0;

	Hashtable<String, Integer> variables = new Hashtable<String, Integer>();

	BudiComp(CommonTree root) {
		this.root = root;
	}

	void checkVar(String var) throws Exception {
		if (!variables.containsKey(var)) {
			throw new Exception("Variable '"+var+"' not declared");
		}
	}

	void compileExpr( CommonTree expr) throws Exception{
		//5. kita perlu menambahkan kasus untuk menangani identifier/variable. Ini relatif mudah:
		//karena sama dengan sebelumnya, hanya saja di push ke eax atau alamat memori
		if (expr.getType()==BahasaBudi2Lexer.INT) {
			result.append("pushl   $"+expr.getText()+"\n");
			return;
		}
		if (expr.getType()==BahasaBudi2Lexer.ID) {
			checkVar(expr.getText());
			result.append("movl   "+expr.getText()+", %eax\n");
			result.append("pushl  %eax\n");
			return;
		}
		//Dan kasus untuk Unary:
		if (expr.getChildCount()==1) {
			if (expr.getText().equals("+")) {
				/*nothing changed*/
				compileExpr((CommonTree)expr.getChild(0));
				return;
			}
			if (expr.getText().equals("-")) {
				compileExpr((CommonTree)expr.getChild(0));
				result.append("popl   %eax\n");
				result.append("negl   %eax\n");
				result.append("pushl   %eax\n");
				return;
			}
		}
		if (expr.getText().equals("+") || expr.getText().equals("-")
			|| expr.getText().equals("*")) {
			compileExpr((CommonTree)expr.getChild(0));
			compileExpr((CommonTree)expr.getChild(1));
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

	void compileDeclaration( CommonTree  decl) {
		result.append(".bss\n");
		for (Object e: decl.getChildren()) {
			CommonTree et = (CommonTree)e;
			String var = et.getText();
			if (!variables.containsKey(var)) {
				result.append(".globl "+ var+"\n");
				result.append(".size  "+var+", 4\n");
				result.append(var+":\n");
				result.append(".zero 4\n");
			}
			variables.put(var, 0);
		}
		result.append(".section	.rodata\n");
		result.append(".print_str_format:\n");
		result.append(".string	\"%s\\n\"\n");
		result.append(".print_int_format:\n");
		result.append(".string	\"%d\\n\"\n");
		result.append(".scan_int_format:\n");
		result.append(".string	\"%d\"\n");
		result.append(".text\n");
		result.append(".globl main\n");
		result.append(".type	main, @function\n");
		result.append("main:\n");
	}

	void compileInput( CommonTree expr) throws Exception {
		String var = expr.getText();
		checkVar(var);
		result.append("pushl   $"+var+"\n");
		result.append("push   $.scan_int_format\n");
		result.append("call   scanf\n");
		result.append("popl   %ebx\n");
		result.append("popl   %ebx\n");
	}


// 2. Mencetak sebuah integer sangat mudah, tapi mencetak string agak sulit.
// Kita perlu meletakkan sebuah string di alamat memori, lalu memberikan alamat memori itu ke fungsi printf.


// 3. Kita bisa meletakkan string-string tersebut di mana saja,
// tapi untuk mudahnya, semua string diletakkan di bagian akhir assembly setelah kode program terakhir.
// Kita perlu mendeklarasikan sebuah string untuk penyimpanan sementara, nanti setelah semua kode program dihasilkan,
// kita tempelkan string ini di akhir kode program.
//cek line 10, StringBuffer strings = new StringBuffer();

// 4. Di assembly semua string harus diberi nama (tepatnya diberi label alamat),
//jadi kita perlu memberikan nama untuk merujuk pada string tersebut. Supaya tidak bentrok,
//kita gunakan saja nama dengan format ._str_XX dengan xx adalah nomor string. Setiap string kita beri nomor menaik.
//Kita gunakan counter global agar semua nomor sifatnya unik: cek diatas... line 12

	void compilePrint( CommonTree expr) throws Exception {
		if (expr.getType()==BahasaBudi2Lexer.STRING) {
			String s = expr.getText();
			/*remove first ' and last ' from string*/
			//sama ke yg kesatu regex buat hapus ''
			s = s.replaceAll("^'", "");
			s = s.replaceAll("'$", "");
			//Bagian pertama adalah penanganan untuk print 'string', di bagian kedua adalah untuk print var.
			//Untuk setiap string, kita hasilkan ID baru, lalu simpan di variabel strings:
			strcounter++;
			strings.append("._str_"+strcounter+":\n");
			strings.append(".string \""+s+"\"\n");
			result.append("push   $._str_"+strcounter+"\n");
			//Kita panggil printf seperti pada tutorial sebelumnya,
			//tapi parameter kedua (yang dipush pertama, karena urutannya terbalik) adalah string yang baru saja kita buat tadi:
			result.append("push   $.print_str_format\n"); //this one
			result.append("call   printf\n");
			result.append("popl   %ebx\n");
			result.append("popl   %ebx\n");
		} else {
			//Untuk bagian print dengan variabel, kita menggunakan push var,
			//tanpa $ karena kita ingin nilainya yang dicetak, bukan alamatnya:
			String var = expr.getText();
			checkVar(var);
			result.append("push   "+var+"\n"); //and this one is da different
			result.append("push   $.print_int_format\n");
			result.append("call   printf\n");
			result.append("popl   %ebx\n");
			result.append("popl   %ebx\n");
		}
	}

//
	void compileAssignment( CommonTree astmt) throws Exception {
		CommonTree var = (CommonTree)astmt.getChild(0);
		checkVar(var.getText());
		CommonTree expr = (CommonTree)astmt.getChild(1);
		compileExpr(expr);
		result.append("popl %eax\n");
		result.append("movl %eax, "+var.getText()+"\n");
	}


//sama juga seperti yg kesatu ada macem macem kan, di kembalikan ke masing masing fungsinya
	void compileStatement( CommonTree expr) throws Exception{
		switch (expr.getType()) {
		case BahasaBudi2Lexer.DECLARATION:
			compileDeclaration( expr);
			break;
		case BahasaBudi2Lexer.INPUT:
			compileInput( (CommonTree)expr.getChild(0));
			break;
		case BahasaBudi2Lexer.PRINT:
			compilePrint( (CommonTree)expr.getChild(0));
			break;
		case BahasaBudi2Lexer.ASSIGNMENT:
			compileAssignment( expr);
			break;
		}
	}

//sama dengan yg kesatu...
	void compileStatementList( CommonTree exprlist) throws Exception{
		for (Object e: exprlist.getChildren()) {
			compileStatement( (CommonTree)e);
		}
	}

//1.bagian awal dari sebuah bahasa assembly gan...
//kita perlu menambah, see contoh di yg ke dua...
	String compile() throws Exception {
		compileStatementList( root);
		result.append("ret\n");
		result.append(".size	main, .-main\n");
		result.append(".section	.rodata\n");
		result.append(strings.toString());
		return result.toString();
	}

	public static void main(String argv[]) throws Exception {
		if (argv.length!=1) {
			System.out.println("Penggunaan: BudiComp <kodingan.bul>");
			return;
		}
		BahasaBudi2Lexer lex = new BahasaBudi2Lexer(new ANTLRFileStream(argv[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		BahasaBudi2Parser g = new BahasaBudi2Parser(tokens);
		BahasaBudi2Parser.prog_return r = g.prog();
		CommonTree ct = (CommonTree)r.getTree();
		BudiComp el = new BudiComp(ct);
		String result = el.compile();
		String asmname = argv[0] + ".s";
		FileWriter fw = new FileWriter(asmname);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(result);
		fw.close();
		String command[] = {"gcc", "-m32", asmname, "-o", argv[0]+".exe"};
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
	}
}
