grammar LDRate;

/*
 * Parser rules
 */
loading_discharging_rate        : .*?(RATE_NOMINAL RATE_UNIT? RATE_TYPE .*?)+;
loading_rate                    : LOADING_RATE_IDENTIFIER RATE_NOMINAL RATE_TYPE;
discharging_rate                : DISCHARGING_RATE_IDENTIFIER RATE_NOMINAL RATE_TYPE;     
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
 * Lexer Rules
 */



/*
 * LD RATE lexer rule 
 */
WS                      : (' ' | '\t')+ {skip();};
RATE_NOMINAL    : DIGIT+ (DOT|COMMA)? DIGIT*;
RATE_TYPE       :   (S H E X  E I U)|
                            (E I U) |
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
RATE_UNIT          : M T S? ((SLASH|P E R)?  D A Y)?;
LD_RATE_IDENTIFIER : L D UNDERLINE R A T E;
LOADING_RATE_IDENTIFIER : L O A D R A T E;
DISCHARGING_RATE_IDENTIFIER : D I S C? H? A? R? G? E? (R A T E)?;