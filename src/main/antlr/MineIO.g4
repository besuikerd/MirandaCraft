grammar MineIO;

@header{
package com.besuikerd.mirandacraft.mineio.parser;
}

//Parser rules

program: statement*;

statement:
    ( declaration
    | assignment
    | block
    | condition
    | exp
    | functionDeclaration
    | whileStatement
    | foreachStatement
    | returnStatement
    ) SEMICOLON?
;
    
declaration     : typeRef Id (BECOMES exp)?;
assignment      : Id assignmentType exp;
block           : LCURLY statement* RCURLY;
condition       : IF LPAREN exp RPAREN statement (ELSE statement)?;
whileStatement  : WHILE LPAREN exp RPAREN statement;
foreachStatement: FOREACH LPAREN exp AS Id RPAREN statement;


returnStatement : RETURN exp;

functionDeclaration : FUNCTION Id LPAREN (formalParameter (COMMA formalParameter)*)? RPAREN (COLON typeRef)? functionBody;
formalParameter: typeRef Id;
functionBody : statement;


assignmentType : (BECOMES | BECOMESADD | BECOMESSUB | BECOMESMUL | BECOMESDIV);

exp:

      Int #ExpIntLiteral
    | (TRUE | FALSE) #ExpBooleanLiteral
    | StringLiteral #ExpStringLiteral
    | LBRACKET (exp (COMMA exp)*)? RBRACKET #ExpArrayLiteral
    | LPAREN (exp (COMMA exp)*)? RPAREN #ExpTupleLiteral
    | LPAREN exp RPAREN #ExpParens
    | Id LPAREN (exp (COMMA exp)*)? RPAREN #ExpFunctionCall
    | Id #ExpVarRef
    | exp (MUL | DIV | MOD) exp #ExpBinary
    | exp (ADD | SUB) exp #ExpBinary
    | exp (GT | GTEQ | LT | LTEQ) exp #ExpBinary
    | exp (EQUALS | NOTEQUALS) exp #ExpBinary
    | exp AND exp #ExpBinary
    | exp OR exp #ExpBinary
    | exp ARROWRIGHT exp #ExpTransfer
    | exp AT exp        #ExpSelect
    | exp DOT Id #ExpField
    | (NOT | TILDE) exp #ExpUnary
    | exp LBRACKET exp RBRACKET #ExpIndexed
    | itemDescriptor #ExpItemDescriptor
    //| recipe
;

itemDescriptor: LT itemModName COLON itemName GT;
itemModName: Id;
itemName: Id;

typeRef:
      TYPE_ITEM          #TypeItem
    | TYPE_CONTAINER     #TypeContainer
    | TYPE_RECIPE        #TypeRecipe
    | TYPE_INT      #TypeInt
    | TYPE_STRING    #TypeString
    | TYPE_BOOLEAN #TypeBoolean
    | LBRACKET typeRef RBRACKET  #TypeArray
    | LPAREN (typeRef (COMMA typeRef)*)? RPAREN #TypeTuple
;
arrayRef: typeRef LBRACKET RBRACKET;

//Lexer rules
TYPE_ITEM        : 'item';
TYPE_CONTAINER   : 'container';
TYPE_RECIPE      : 'recipe';

TYPE_INT    : 'int';
TYPE_STRING : 'String' | 'string'; 
TYPE_BOOLEAN: 'boolean';

TRUE        : 'true';
FALSE       : 'false';

IF          : 'if';
ELSE        : 'else';

LPAREN      : '(';
RPAREN      : ')';

LBRACKET    : '[';
RBRACKET    : ']';

LCURLY      : '{';
RCURLY      : '}';

COLON       : ':';
SEMICOLON   : ';';
COMMA       : ',';

ADD         : '+';
SUB         : '-';
MUL         : '*';
DIV         : '/';
MOD         : '%';

GT          : '>';
GTEQ        : '<=';
LT          : '<';
LTEQ        : '>=';
EQUALS      : '==';
NOTEQUALS   : '!=';

AND         : '&&';
OR          : '||';

AT          : '@';
NOT         : '!';
TILDE       : '~';
QUOTE       : '"';

BECOMES     : '=';
BECOMESADD  : ADD BECOMES;
BECOMESSUB  : SUB BECOMES;
BECOMESDIV  : DIV BECOMES;
BECOMESMUL  : MUL BECOMES;

FUNCTION    : 'function';
RETURN      : 'return';
DOT         : '.';

WHILE       : 'while';
FOREACH     : 'foreach';
AS          : 'as';

ARROWRIGHT  : '->';

Comment : ('//').*? '\n' -> skip;
WhiteSpace : [ \n\r\t]+ -> skip;

StringLiteral: QUOTE StringCharacter* QUOTE; 
fragment StringCharacter: ~["\\] | EscapeSeq;
fragment EscapeSeq: '\\' [btnfr"'\\];


Id: LETTER (LETTER | DIGIT)*;
Int: '-'? DIGIT+;

fragment LETTER: LOWER | UPPER;
fragment LOWER: [a-z];
fragment UPPER: [A-Z];
fragment DIGIT: [0-9];