grammar PortDestination;

/*
 * Parser rules
 */
port_destination    : PORT_IDENTIFIER? PORT_FROM PORT_SIGN PORT_TO STOPPER ;
//                    PORT_TO;
//loading_port        : LOAD_PORT_IDENTIFIER PORT_FROM;
//discharging_port    : DISCH_PORT_IDENTIFIER PORT TO; 


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
fragment GREATER_THAN    :    '>';
fragment PERCENT         :    '%'  ;
fragment PARENTHESIS_OPEN  :    '('  ;
fragment PARENTHESIS_CLOSE :    ')'  ;    
fragment LETTER            : [a-zA-Z] ;


/*
 * Lexer Rules
 */

WS                      : (' ' | '\t')+ {skip();};



/*
 * PORT lexer rules
 */
PORT_SIGN               : SLASH | (MINUS GREATER_THAN);
PORT_FROM               : LETTER (LETTER|COMMA)* ;
PORT_IDENTIFIER         : (L SLASH D P O R T COLON?)|(P O R T);
PORT_TO                 : LETTER (LETTER|COMMA)* ;
LOAD_PORT_IDENTIFIER    : L O A D P O R T;
DISCH_PORT_IDENTIFIER   : D I S C H A? R? G? I? N? G? P O R T;
STOPPER                 : MINUS;

