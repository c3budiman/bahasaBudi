//pretty important library :V
import java.util.Hashtable;
import java.util.Scanner;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

class BahasaBudi2Lang {

	CommonTree root;

	Hashtable<String, Integer> variables = new Hashtable<String, Integer>();
	Scanner scanner;

	BahasaBudi2Lang(CommonTree root) {
		this.root = root;
		scanner = new Scanner(System.in);
	}

//5.Supaya tidak penasaran, pemeriksaan apakah variabel sudah dideklarasikan
//dilakukan dengan memanggil method containsKey milik Hashtable.
	void checkVar(String var) throws Exception {
		if (!variables.containsKey(var)) {
			throw new Exception("Variable '"+var+"' not declared");
		}
	}

//8.terakhir
	int evaluateExpr(CommonTree expr) throws Exception{
		//Jika kita bertemu dengan variabel, kita cek apakah variabel tersebut ada, lalu kita kembalikan nilainya:
		if (expr.getType()==BahasaBudi2Lexer.INT) {
			return Integer.parseInt(expr.getText());
		}
		if (expr.getType()==BahasaBudi2Lexer.ID) {
			checkVar(expr.getText());
			return variables.get(expr.getText());
		}
		//Untuk unary plus dan minus juga tidak sulit.
		//Kita tambahkan satu buah if untuk memeriksa jumlah anak.
		//Jika jumlahnya satu, maka itu unary, selain itu pasti punya dua anak (binary).
		//what is unary dan binary?
		//Operator unary adalah operator yang digunakan untuk melakukan operasi metematik yang hanya melibatkan satu buah operand
		//ex : positive 1, negative 1, 1++, etc...
		//binary udah tau lah dari unary satu klo binary?
		//ex : a+b, c+d, 10 + 30, etc....
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

	//3.Pertama kita bahas dulu evaluasi deklarasi. Supaya terdeklarasi,
	//setiap variabel dimasukkan ke hash table dan diberi nilai nol.
	void evaluateDeclaration(CommonTree  decl) {
		for (Object e: decl.getChildren()) {
			CommonTree et = (CommonTree)e;
			variables.put(et.getText(), 0);
		}
	}

	//4.Berikutnya, evaluasi input. Pertama kita cek dulu apakah variabelnya sudah
	//dideklarasikan atau belum (jika belum, exception akan dilemparkan, dan program akan berhenti):
	//ingat pas semester 5 kita ngoding java ada yg namanya scanner? yak ini pake itu ada diatas....
	void evaluateInput(CommonTree expr) throws Exception {
		String var = expr.getText();
		checkVar(var);
		int i = scanner.nextInt();
		variables.put(var, i);
	}

//6. Setelah itu kita bahas bagaimana mengevaluasi print.
// Ada dua bentuk, yang mencetak variabel dan yang mencetak string.
// Sebenarnya ini bisa dibuat lebih generik, tapi versi ini demi kesederhanaan tutorial.
// Jika tipenya adalah string, maka kita perlu menghapus tanda petik di awal dan di akhir string.
// Mudahnya, gunakan regex di Java. Setelah itu cetak stringnya dengan System.out.println.
// Jika yang dicetak akan variabel, kita cek dulu apakah variabelnya ada atau tidak.
// Jika ada, kita ambil nilainya dengan get, dan kita cetak ke layar.
	void evaluatePrint(CommonTree expr) throws Exception {
		if (expr.getType()==BahasaBudi2Lexer.STRING) {
			String s = expr.getText();
			/*remove first ' and last ' from string*/
			//this one is regex.... sentuh regex101.com to learn about regex
			s = s.replaceAll("^'", "");
			s = s.replaceAll("'$", "");
			System.out.println(s);
		} else {
			String var = expr.getText();
			checkVar(var);
			System.out.println(variables.get(var));
		}
	}

//7.Dan yang terakhir adalah assignment. Anak pertama adalah variabel dan anak kedua adalah ekspresi.
//Kita sudah punya kode untuk evaluasi ekspresi dari tutorial sebelumnya,
//jadi yang diperlukan adalah: cek apakah variabel sudah dideklarasikan, evaluasi ekspresi, dan masukkan hasilnya dengan put.
	void evaluateAssignment(CommonTree astmt) throws Exception {
		CommonTree var = (CommonTree)astmt.getChild(0);
		checkVar(var.getText());
		CommonTree expr = (CommonTree)astmt.getChild(1);
		int res = evaluateExpr(expr);
		variables.put(var.getText(), res);
	}

//2.Tapi ada banyak statement, jadi kita perlu mendelegasikan ke method yang sesuai.
//Kalau program sudah semakin rumit, delegasi bisa dilakukan ke kelas lain.
	void evaluateStatement(CommonTree expr) throws Exception{
		switch (expr.getType()) {
		case BahasaBudi2Lexer.DECLARATION:
			evaluateDeclaration(expr);
			break;
		case BahasaBudi2Lexer.INPUT:
			evaluateInput((CommonTree)expr.getChild(0));
			break;
		case BahasaBudi2Lexer.PRINT:
			evaluatePrint((CommonTree)expr.getChild(0));
			break;
		case BahasaBudi2Lexer.ASSIGNMENT:
			evaluateAssignment(expr);
			break;
		}
	}

//1.Mengevaluasi daftar statement sangat mudah,
//Anda cukup meloop semua statement, dan mengevaluasi masing-masing statement:
	void evaluateStatementList(CommonTree exprlist) throws Exception{
		for (Object e: exprlist.getChildren()) {
			evaluateStatement((CommonTree)e);
		}
	}
//start from here read and throw exception here too....
	void evaluate() throws Exception {
		evaluateStatementList(root);
	}

	public static void main(String argv[]) throws Exception {
		if (argv.length!=1) {
			System.out.println("Penggunaan: BahasaBudi2Lang <namafile.e>");
			return;
		}
		BahasaBudi2Lexer lex = new BahasaBudi2Lexer(new ANTLRFileStream(argv[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		BahasaBudi2Parser g = new BahasaBudi2Parser(tokens);
		BahasaBudi2Parser.prog_return r = g.prog();
		CommonTree ct = (CommonTree)r.getTree();
		BahasaBudi2Lang el = new BahasaBudi2Lang(ct);
		//this one in bottom start all the code...
		el.evaluate();
	}
}
