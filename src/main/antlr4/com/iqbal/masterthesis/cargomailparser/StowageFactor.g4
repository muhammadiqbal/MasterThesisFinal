grammar StowageFactor;
/*
 * Parser rules
 */
stowage_factor      : .* (STOWAGE_FACTOR_IDENTIFIER? STOWAGE_FACTOR_ABOUT? (STOWAGE_FACTOR_NOMINAL STOWAGE_FACTOR_UNIT));

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
fragment LETTER            : [a-zA-Z\u0080-\u00FF_] ;

/*
 * STOWAGE FACTOR lexer rules
 */
WS                      : (' ' | '\t')+ {skip();};
STOWAGE_FACTOR_IDENTIFIER : ((PARENTHESIS_OPEN S DOT F PARENTHESIS_CLOSE)|(S (DOT|SLASH)? F)|(S F)|(S T W)) COLON?;
STOWAGE_FACTOR_NOMINAL    : DIGIT+ (DOT|COMMA)? DIGIT*;
STOWAGE_FACTOR_UNIT       : W O G| PLUS;
STOWAGE_FACTOR_ABOUT      : (PLUS SLASH MINUS)|(A B O U T);