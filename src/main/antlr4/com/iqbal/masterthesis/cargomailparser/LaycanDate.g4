grammar LaycanDate;

/*
 * Parser rules 
 */
laycan              : LAYCAN_IDENTIFIER? FIRST_DAY DATE_RANGE_SEPARATOR LAST_DAY (DATE_SEPARATOR)? DATE_MONTH (DATE_SEPARATOR DATE_YEAR?)?;


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

// /*
//  * Lexer Rules
//  */

WS                      : (' ' | '\t')+ {skip();};
DATE_MONTH      : J A N (U A R Y)?   
                  |F E B (R U A R Y)? 
                  |M A R (C H)?   
                  |A P R (I L)?   
                  |M A Y                        
                  |J U N E? 
                  |J U L Y? 
                  |A U G (U S T)?   
                  |S E P (T E M B E R)?                 
                  |O C T (O B E R)? 
                  |N O V (E M B E R)? 
                  |D E C (E M B E R)? ;
FIRST_DAY        : ('0'|'1'|'2' DIGIT) |('3' ('0'|'1')) ;
LAST_DAY        : ('0'|'1'|'2' DIGIT) |('3' ('0'|'1')) ;
DATE_YEAR       : DIGIT DIGIT DIGIT DIGIT;
DATE_SEPARATOR          : MINUS|SLASH|DOT;
DATE_RANGE_SEPARATOR    : MINUS|(T O)|SLASH;
LAYCAN_IDENTIFIER       : (L A Y C A N);