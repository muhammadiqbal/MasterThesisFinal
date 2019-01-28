grammar Description;

/*
 * Parser rules
 */
description         : .*? (DESCRIPTION_IDENTIFIER DESCRIPTION_DESC EOF .*?); 

/*
 * Fragment
 */
fragment DIGIT  : [0123456789];
fragment A      : [aA]; // match either an 'a' or 'A'
fragment B      : [bB];
fragment C      : [cC];
fragment D      : [dD];
fragment E      : [eE];
fragment F      : [fF];
fragment G      : [gG];
fragment H      : [hH];
fragment I      : [iI];
fragment J      : [jJ];
fragment K      : [kK];
fragment L      : [lL];
fragment M      : [mM];
fragment N      : [nN];
fragment O      : [oO];
fragment P      : [pP];
fragment Q      : [qQ];
fragment R      : [rR];
fragment S      : [sS];
fragment T      : [tT];
fragment U      : [uU];
fragment V      : [vV];
fragment W      : [wW];
fragment X      : [xX];
fragment Y      : [yY];
fragment Z      : [zZ];
fragment DOT             :    '.'  ;
fragment PLUS            :    '+'  ;
fragment MINUS           :    '-'  ;
fragment COLON           :    ':'  ;
fragment COMMA           :    ','  ;
fragment QUOTE           :    '"'  ;
fragment EQUALS          :    '='  ;
fragment SEMICOLON       :    ';'  ;
fragment UNDERLINE       :    '_'  ;
fragment BACKSLASH       :    '\\' ;
fragment SINGLEQUOTE     :    '\'' ;
fragment SLASH           :    '/'  ;
fragment ARROW           :    '->' ;
fragment PERCENT         :    '%'  ;
fragment PARENTHESIS_OPEN  :    '('  ;
fragment PARENTHESIS_CLOSE :    ')'  ;    
fragment LETTER            : [a-zA-Z0123456789.\u0080-\u00FF_] ;

// /*
//  * Lexer Rules
//  */

fragment WS                      : (' ' | '\t')+;


/*
 * DESCRIPTION leer rules
 */
DESCRIPTION_IDENTIFIER    : ((D E S C R? I? P? T? I? O? N?) |(S H I P M E N T S?)|(C A R G O WS O F F E R)) WS COLON? WS;
DESCRIPTION_DESC          : LETTER (LETTER|DIGIT|WS)*;