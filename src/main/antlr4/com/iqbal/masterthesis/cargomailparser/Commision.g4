grammar Commision;
/*
 * Parser Rules
 */
//commision           : .*? (COMMISION_IDENTIFIER? COMMISION_ABOUT? COMMISION_NOMINAL COMMISION_UNIT? COMMISION_TYPE .*?)+;
commision           : .*? (COMMISION_IDENTIFIER? COMMISION_ABOUT? COMMISION_NOMINAL COMMISION_UNIT? COMMISION_TYPE .*?);

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
fragment QUOTE           :    '"' ;
fragment EQUALS          :    '='  ;
fragment SEMICOLON       :    ';'  ;
fragment UNDERLINE       :    '_'  ;
fragment BACKSLASH       :    '\\' ;
fragment SINGLEQUOTE     :    '\'' ;
fragment SLASH           :    '/'  ;
fragment ARROW           :    '->' ;
fragment PERCENT         :    '%'  ;

/*
 * Lexer Rules
 */
WS                      : (' ' | '\t')+ {skip();};
COMMISION_IDENTIFIER    : C O M M I? S? I? O? N?;
COMMISION_ABOUT         : (PLUS SLASH MINUS)|(A B O? U? T);
COMMISION_NOMINAL       : DIGIT+ (DOT|COMMA)? DIGIT*;
COMMISION_UNIT          : PERCENT|(P C T);
COMMISION_TYPE          : I A C| C O M M H E R E | A D D |T T L;    

