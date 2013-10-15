grammar BaseSql;

//TOKENS

PLUS    : '+' ;
MINUS   : '-' ;
STAR    : '*' ;
DIV     : '/' ;
MOD     : '%' ;
AND     : 'and' ;
OR      : 'or' ;
AS      : 'as' ;
BETWEEN : 'between' ;
NOT     : 'not' ;
NULL    : 'null' ;
IN      : 'in' ;
IS      : 'is' ;

L_PAREN : '(' ;
R_PAREN : ')' ;
COMA    : ',' ;
DOT     : '.' ;

LT_EQ   : '<=' | '!>' ;
LT      : '<' ;
GT_EQ   : '>=' | '!<' ;
GT      : '>' ;
EQ      : '=' ;
NOT_EQ  : '!=' | '<>' ;

SELECT   : 'select' ;
FROM     : 'from' ;
JOIN     : 'join' ;
WHERE    : 'where' ;
ORDER    : 'order' ;
GROUP    : 'group' ;
BY       : 'by' ;
ASC      : 'asc';
DESC      : 'desc';

CASE     : 'case' ;
WHEN     : 'when' ;
THEN     : 'then' ;
ELSE     : 'else' ;
END      : 'end' ;

INNER    : 'inner' ;
OUTER    : 'outer' ;
CROSS    : 'cross' ;
LEFT     : 'left' ;
RIGHT    : 'right' ;
FULL     : 'full' ;
ON       : 'on' ;

//LEXER

BOOLEAN : 'true' | 'false';

ID  : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

INT : '0'..'9'+ ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"' | '\'' ( ESC_SEQ | ~('\''|'\\') )* '\''
    ;

//TODO: token for comments (--)

WS  :   [ \t\r\n]+ -> skip;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;


//PARSER

query :
    (SELECT selectExpression)?
    (FROM fromExpression)?
    (WHERE whereClause)?
    (GROUP BY groupByClause)?
    (ORDER BY orderByClause)?
    ;

selectExpression : selectElement (COMA selectElement)* ;

selectElement : (STAR | condition (AS ID)?) ;

tableName : ID (AS ID)? ;

fromExpression : fromElement (COMA fromElement)* ;

fromElement : 
    tableName 
    | L_PAREN fromElement R_PAREN 
    | fromElement (
        INNER 
        | ((LEFT | RIGHT | FULL) OUTER? | OUTER )
        | CROSS)? 
    JOIN fromElement ON condition;

groupByClause : condition (COMA condition)* ;

orderByClause : orderByElement (COMA orderByElement)* ;

orderByElement : condition direction=(ASC | DESC)?;

whereClause : value=condition ;

simpleCondition : value=condition EOF;

condition :
    NOT value=condition #NotCondition
    | L_PAREN condition R_PAREN #SkipCondition
    | left=condition AND right=condition #AndOperator
    | left=condition OR right=condition #OrOperator
    | predicate #SkipCondition
;

predicate : 
    value=expression #SkipPredicate
    | value=expression IS NOT? NULL #IsNullPredicate
    | left=expression operator=( LT_EQ | LT | GT_EQ | GT | EQ | NOT_EQ ) right=expression #ComparePredicate
    | value=expression NOT? detailedPredicate=subPredicate #NegatablePredicate
    ;

subPredicate:
    BETWEEN lower=expression AND upper=expression #BetweenPredicate
    | IN L_PAREN el+=condition (COMA el+=condition)* R_PAREN #InPredicate
      //LIKE etc.
    ;

comparison : 
    LT_EQ 
    | LT 
    | GT_EQ 
    | GT 
    | EQ 
    | NOT_EQ
    ;

expression:
    L_PAREN condition R_PAREN #SkipExpression 
    | operator = ( PLUS | MINUS ) value=condition #UnaryOperator
    | left=expression operator=( STAR | DIV | MOD ) right=expression #ArithmeticOperator 
    | left=expression operator=( PLUS | MINUS ) right=expression #ArithmeticOperator 
    | CASE valueExpr=condition (WHEN whenExpr+=condition THEN thenExpr+=condition)+ (ELSE elseExpr=condition)? END #CaseOperator
    | CASE (WHEN whenExpr+=condition THEN thenExpr+=condition)+ (ELSE elseExpr=condition)? END #SearchedCaseOperator
    | function #SkipExpression 
    | primitive #SkipExpression 
    ;

function :
    ID L_PAREN el+=condition (COMA? el+=condition)* R_PAREN #SimpleFunction 
    | ID L_PAREN value=condition IN inValue=condition ( FROM from=condition)? R_PAREN #InFunction 
    ;

primitive :
    BOOLEAN #Boolean
    | NULL #Null
    | ID #Field
    | ID DOT ID #TableField
    | INT #Integer
    | FLOAT #Float
    | STRING #String
    ;