grammar Quantity;

/*
 * Parser Rules
 */

quantity            : .*? QUANTITY_IDENTIFIIER? (QUANTITY_LOWER_RANGE QUANTITY_RANGE_SEPARATOR)? (QUANTITY_NOMINAL QUANTITY_UNIT);
 
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

/*
 * Lexer Rules
 */
WS                      : (' ' | '\t')+ {skip();};
QUANTITY_IDENTIFIIER    : (Q U? A? N? T I? T? Y);
QUANTITY_NOMINAL        : DIGIT+ (DOT|COMMA|'`')? DIGIT*;
QUANTITY_UNIT           : (T O N)|(T O N S)|(K G S)|(M T)|(M T S)|(M T O N S)|(D W T)|(C B M);
QUANTITY_UNIT_RANGE_SEPARATOR : SLASH|MINUS;
QUANTITY_UNIT_LOWER_RANGE     : DIGIT+ (DOT|COMMA)? DIGIT*;
//this lexer rule is to be negated 
// in order to disambiagute quantity and LD rate
LD_RATE_TYPE       :   (S H E X  E I U)|
                            (S H E X)|
                            (S H E X  U U)|
                            (S S H E X  E I U)|
                            (S S H E X  U U)|
                            (F H E X  E I U)|
                            (F H E X  U U)|
                            (F S H E X  E I U)|
                            (F S H E X  U U)|
                            (T F H E X  E I U)|
                            (T F H E X  U U)|
                            (P W W D ' ' S H I N C)|
                            (S H I N C)|
                            (S S H I N C)|
                            (P W W D);