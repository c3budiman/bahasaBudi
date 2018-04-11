grammar BahasaBudi2;

options {
 output = AST;
 ASTLabelType =CommonTree;
}

tokens {
	STATEMENT_LIST;
	DECLARATION;
	ASSIGNMENT;
	INPUT;	
	PRINT;		
	INT;
	STRING;
	ID;
}

// START:stat
prog:   declaration stat+ -> ^(STATEMENT_LIST declaration stat+);

stat:   assignment NEWLINE -> assignment
    | input NEWLINE -> input
    | print NEWLINE ->print
    | NEWLINE
    ;
// END:stat

//bagian deklarasi var menggunakan linker id
//kamu dapat menginput berbagai var dengan production rules menggunakan koma
declaration
	:	
	'var' ID ( ',' ID)* NEWLINE -> ^(DECLARATION ID*)
	;
	
//input ini akan meminta input ke user di terminal dan hasilnya bisa dimasukkan langsung ke var (ID)
input	:	
	'masukkan' ID -> ^(INPUT ID)
	;
	
//untuk print disini, kamu bisa cetak variabel atau cetak string
print   :	
	'cetak' ID -> ^(PRINT ID)
	| 'cetak' STRING -> ^(PRINT STRING)
	;
	
//ini seperti kaidah pemberian nilai variabel ex nilai = 100, uts = free 
assignment
	:			
	ID '=' expr -> ^(ASSIGNMENT ID expr)
	;

// START:expr, dimana ini logika utama buat bahasabudi yg tidak sempurna ini :v
//1. ini adalah operasi penjumlahan atau pengurangan dari sebuah multexpr, mult expr ini bisa byk bisa jadi cuman 1 atau 2. 
//lihat atom dlu setelah ini.
expr:   multExpr (('+'|'-')^ multExpr)*
    ; 
    
//3.untuk multExpr ini akan menangani aturan produksi dari perkalian, masukkan nya adalah unaryExpr, kenapa ditulis seperti ini?
//kenapa tidak memiliki masukkan atom saja?
//karena perkalian tingakatan nya lebih tinggi dari unary operation yaitu plus dan minus. 
multExpr
    :   unaryExpr ('*'^ unaryExpr)*
    ; 
//4.yang satu ini akan menangani proses unary dimana dia akan menjumlahkan atau mengurangkan dari atom.
unaryExpr
	: unary_op^ atom
	| atom
	;    

//2.atom ini bisa dibilang bagian terkecil dari sebuah operan, dapat berupa variabel dapat berupa integer langsung.
//dan dapat juga operasi dari expr ex : ( 2 + 3 ) 
//kenapa dibeginikan? soalnya klo operasi dalam kurung itu di dahulukan gan walau perkalian juga :P
atom:   INT 
    | ID
    |   '(' expr ')' -> expr
    ;
//nanti ini ngambil dari tokens untuk menangani plus atau minus
unary_op:	
	PLUS
	|MINUS
	;
    
// END:expr
//ini adalah tokens, dimana aturan produksi terkecil disimpan disini misal int 0..9 lalu ada plus nya
//itu artinya bisa dimasukkan 0, 0 substring 9 => 09 dst nya....
// START:tokens
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
ID:    'a'..'z'+ ;
WS  :   (' '|'\t'|'\n'|'\r')+ {skip();} ;
STRING	:	 '\''( ~('\'') )*'\'' ;
PLUS	:	 '+';
MINUS :	 '-';
// END:tokens