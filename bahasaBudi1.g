grammar bahasaBudi1;

options {
 output = AST;
 ASTLabelType =CommonTree;
}

tokens {
	EXPRESSION_LIST;
	EXPRESSION;
	INT;
}

// START:stat
prog:   stat+ -> ^(EXPRESSION_LIST stat+);

stat:   expr NEWLINE -> ^(EXPRESSION expr)
    |   NEWLINE
    ;
// END:stat

// START:expr
expr:   multExpr (('+'|'-')^ multExpr)*
    ; 

multExpr
    :   atom ('*'^ atom)*
    ; 

atom:   INT 
    |   '(' expr ')' -> expr
    ;
// END:expr

// START:tokens
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t'|'\n'|'\r')+ {skip();} ;
// END:tokens