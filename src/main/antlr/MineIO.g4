grammar MineIO;

@header{
package com.besuikerd.mirandacraft.mineio.parser;

import com.besuikerd.mirandacraft.mineio.namespace.NamespaceEntry;
}

//Parser rules

program: statementSemicolon*;

statementSemicolon: statement SEMICOLON?;

statement:
          typeRef variable (BECOMES exp)? #statementDeclaration
        | variable assignmentType exp #statementAssignment
        | LCURLY statementSemicolon* RCURLY #statementBlock
        | IF LPAREN exp RPAREN statement (ELSE statement)? #statementCondition
        | exp #statementExpression
        | FUNCTION variable LPAREN (formalParameter (COMMA formalParameter)*)? RPAREN (COLON typeRef)? functionBody #statementFunctionDeclaration
        | WHILE LPAREN exp RPAREN statement #statementWhile
        | FOREACH LPAREN exp AS variable RPAREN statement #statementForeach
        | RETURN exp #statementReturn
;

formalParameter: typeRef variable;
functionBody : statement;


assignmentType : 
      BECOMES       #assignmentTypeBecomes 
    | BECOMESADD    #assignmentTypeBecomesAdd
    | BECOMESSUB    #assignmentTypeBecomesSub
    | BECOMESMUL    #assignmentTypeBecomesMul
    | BECOMESDIV    #assignmentTypeBecomesDiv
;

exp:

      Int #ExpIntLiteral
    | (TRUE | FALSE) #ExpBooleanLiteral
    | StringLiteral #ExpStringLiteral
    | LBRACKET (exp (COMMA exp)*)? RBRACKET #ExpArrayLiteral
    | LPAREN (exp (COMMA exp)*)? RPAREN #ExpTupleLiteral
    | LPAREN exp RPAREN #ExpParens
    | variable LPAREN (exp (COMMA exp)*)? RPAREN #ExpFunctionCall
    | variable #ExpVarRef
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

variable locals[NamespaceEntry namespaceEntry]: Id;

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