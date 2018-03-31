grammar Bulat;

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

declaration
	:	
	'var' ID ( ',' ID)* NEWLINE -> ^(DECLARATION ID*)
	;
input	:	
	'input' ID -> ^(INPUT ID)
	;
print   :	
	'print' ID -> ^(PRINT ID)
	| 'print' STRING -> ^(PRINT STRING)
	;

assignment
	:			
	ID '=' expr -> ^(ASSIGNMENT ID expr)
	;
// START:expr
expr:   multExpr (('+'|'-')^ multExpr)*
    ; 

multExpr
    :   unaryExpr ('*'^ unaryExpr)*
    ; 

unaryExpr
	: unary_op^ atom
	| atom
	;    

atom:   INT 
    | ID
    |   '(' expr ')' -> expr
    ;

unary_op:	
	PLUS
	|MINUS
	;
    
// END:expr

// START:tokens
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
ID:    'a'..'z'+ ;
WS  :   (' '|'\t'|'\n'|'\r')+ {skip();} ;
STRING	:	 '\''( ~('\'') )*'\'' ;
PLUS	:	 '+';
MINUS :	 '-';
// END:tokens
