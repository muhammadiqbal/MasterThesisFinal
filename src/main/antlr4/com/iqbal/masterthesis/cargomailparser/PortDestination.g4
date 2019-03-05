grammar PortDestination;

/*
 * Parser rules
 */
port_destination    : PORT_IDENTIFIER? PORT_FROM PORT_SIGN PORT_TO |
                      PORT PORT_SIGN PORT_TO;
//                    PORT_TO;
loading_port        : LOAD_PORT_IDENTIFIER PORT_FROM;
discharging_port    : DISCH_PORT_IDENTIFIER PORT TO; 


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
PORT_IDENTIFIER         : (L SLASH D P O R T COLON?)|(P O R T);
PORT_FROM               : LETTER (LETTER|COMMA)*;
PORT_SIGN               : SLASH | (MINUS GREATER_THAN);
PORT_TO                 : LETTER (LETTER|COMMA)*;
LOAD_PORT_IDENTIFIER    : L O A D P O R T;
DISCH_PORT_IDENTIFIER   : D I S C H A? R? G? I? N? G? P O R T;
STOPPER                 : MINUS;
PORTS                   :'ALEXANDRIA'|
                         'MURMANSK'|
                         'ZARZIS'|
                         'CHORNOMORSK'|
                         'KHERSON'|
                         'ROSTOV'|
                         'MASAN, KOREA'|
                         'MARMARA SEA'|
                         'AVEIRO'|
                         'VILANOVA'|
                         'MARINA DI CARRARA'|
                         'CHIPS IN BULK'|
                         'MISURATA'|
                         'B.ABBAS'|
                         'ISKENDERUN'|
                         'BARCELONA'|
                         'NIKOLAYEV'|
                         'FUGLAFJORDUR'|
                         'MALAGA'|
                         'GULLUK'|
                         'NOVO'|
                         'MARMARA'|
                         'POTI'|
                         'BANKOK'|
                         'KOSCHANG'|
                         'KHERSON'|
                         'ODESSA'|
                         'ISKENDERUN'|
                         'CHITTAGONG'|
                         'LISBON'|
                         'MARBLE BLOCKS'|
                         'HAIFA OR ASHDOD OO'|
                         'MTS GENERAL CARGO UNDER DECK'|
                         'DANGJIN'|
                         'PHU MY (TUNG HO)'|
                         'AQABA'|
                         'NEWCASTLE, AUSTRALIA'|
                         'TARRAGONA'|
                         'CONSTANTA'|
                         'AVEIRO'|
                         'NADOR'|
                         'ISKENDERUN'|
                         'DIKILI (T.AEGEAN)'|
                         'HARMLESS MIN IN BIG BAGS'|
                         'MERSIN'|
                         'MERSIN'|
                         'B.ABBAS'|
                         'CAMPHA, VIETNAM'|
                         'ISDEMIR'|
                         'NIKOLAEV'|
                         'NOVOROSSIYSK'|
                         'EREGLI, TURKEY'|
                         'PSACHNA'|
                         'ISKENDERUN'|
                         'DURBAN FRUIT TERMINAL'|
                         'VARNA'|
                         'YEISK'|
                         'YUZHNY'|
                         'MARMARA'|
                         'YUZHNIY'|
                         'ADABIYA'|
                         'MT ROCK PHOSPHATE IN BULK'|
                         'MARIUPOL'|
                         'MERSIN'|
                         'MERSIN'|
                         'ISKENDERUN'|
                         'KHERSON'|
                         'MALAYSIA'|
                         'MARMARA'|
                         'KHERSON'|
                         'MUMBAI, INDIA'|
                         'AMBARLI'|
                         'CARBONERAS'|
                         'NADOR'|
                         'PLOCE'|
                         'GREECE'|
                         'TUNISIA'|
                         'ROUEN'|
                         'PUERTO DE IBICUY'|
                         'RIJEKA'|
                         'TRIESTE'|
                         'BAKU'|
                         'MARMARA'|
                         'PENANG'|
                         'BINTULU'|
                         'KWINANA'|
                         'BUNBURY'|
                         'IZMIR'|
                         'ADABIYA'|
                         'KANDLA'|
                         'BANDAR'|
                         'MOLCHOPT DRI B'|
                         'ADABIYA / COMOROS'|
                         'BGD. CEMENT'|
                         'ASSALYA IRAN'|
                         'T CLINKER BULK'|
                         'B ABBAS'|
                         'TEKIRDAG'|
                         'NEMRUT'|
                         'SOLIKAMSK'|
                         'BAHRAIN'|
                         'KUANTAN'|
                         'BATAM'|
                         'KABIL'|
                         'CHITTAGONG'|
                         'TSIGGELI'|
                         'ILYICHEVSK'|
                         'SAFI'|
                         'NAANTALI'|
                         'JEDDAH, KSA'|
                         'BAHRAIN'|
                         'NAANTALI, FINLAND'|
                         'MARMARA'|
                         'BANDAR ABBAS'|
                         'KHERSON'|
                         'ISKENDERUN'|
                         'AZOV BLUEWAVE'|
                         'IZMIT'|
                         'CARGO IN PALLETS'|
                         'NIKOLAEV OR ODESSA'|
                         'MUNDRA'|
                         'JUMBO BAGS'|
                         'ASSALYA, IRAN'|
                         'TSIGGELI'|
                         'TURKEY'|
                         'BANDIRMA'|
                         'GABES'|
                         'IZMAIL'|
                         'STYLIDA'|
                         'GDYNIA'|
                         'HARCOURT-ONNE'|
                         'BATA'|
                         'SHUIDONG'|
                         'HAZIRA'|
                         'MUMBAI'|
                         'SAINT PETERSBURG, RUSSIA'|
                         'PLOCE'|
                         'DNEPROPETROVSK'|
                         'RADES'|
                         'BILBAO'|
                         'ISDEMIR'|
                         'GDANSK'|
                         'GDYNIA'|
                         'NADOR'|
                         'BULK STW DWT'|
                         'CHENNAI, ECI'|
                         'AGGREGATES IN BULK'|
                         'KANDLA, WCI'|
                         'IN BULK'|
                         'VALENCIA (SPAIN)'|
                         'NIKOLAEV'|
                         '1 KHERSON,UKRAINE'|
                         'UST-DONETSK, RUSSIA'|
                         'BORDEAUX'|
                         'DANUBE RVR'|
                         'LEGHORN'|
                         'MONFALCONE'|
                         'DEBARS IN COILS '|
                         'NEMRUT'|
                         'OSHAWA (CA)'|
                         'GENOVA'|
                         'HOUSTON'|
                         'GABES'|
                         'FERTS IN BULK'|
                         'BALCHIK, BULGARIA'|
                         'MISURATA'|
                         'IN BULK'|
                         'PIETARSAARI(FINLAND)'|
                         'CHOPT WOOD PULP IN UNITS'|
                         'ISKENDERUN'|
                         'MARBLE CHIPS IN BIG BAGS'|
                         'MERSIN'|
                         'EGYPT'|
                         'MERSIN'|
                         'ISKENDERUN'|
                         'FLUSHING'|
                         'MARIUPOL'|
                         'KHERSON'|
                         'LE HAVRE'|
                         'ROTTERDAM'|
                         '1 MARMARA'|
                         'ODESSA'|
                         'B.I.K.'|
                         'ISKENDERUN,TURKEY'|
                         'NOLA,USA'|
                         'MARMARA'|
                         'HOUSTON,USA'|
                         'ADABIYA EGYPT'|
                         'EL QASR (IRAQ)'|
                         'ROSTOV'|
                         'TURKISH MED'|
                         'IZMIR/XIAMEN'|
                         'GABES'|
                         'IZMIR'|
                         'RAVENNA'|
                         'PLOCE'|
                         'TARANTO'|
                         'SFAX'|
                         'YANBU RED SEA'|
                         'SIPPING BULK MATERIALS COPPER'|
                         'BANDAR ABBAS'|
                         'BULK'|
                         'KOLKATA, EC.INDIA'|
                         'ISKENDERUN'|
                         'NIKOLAEV RIVER PORT'|
                         'RAVENNA'|
                         'LOUISIANA U.S.A'|
                         'MARMARA'|
                         '1SP PG'|
                         'HAIFA'|
                         'LIMESTONE'|
                         'MUMBAI, INDIA'|
                         'POTI'|
                         'AVEIRO-NORTH TERMINAL'|
                         'DERINCE OR HAYDARPASA'|
                         'ADRIATIC'|
                         'MARMARA'|
                         'P.MARGHERA'|
                         'IZMAIL OR CHERNOMORSK'|
                         'NADOR'|
                         'BLK BENTONITE'|
                         'CONSTANZA '|
                         'THESSALONIKI'|
                         'ODESSA'|
                         'ANTALYA'|
                         'MUMBAI, INDIA'|
                         'B.SEA EREGLI'|
                         'B.SEA EREGLI'|
                         'CHENNAI, ECI'|
                         'VARNA'|
                         'BANDAR ABBAS'|
                         '1SP  M. CHINA'|
                         'VARNA OR BOURGAS'|
                         'YUZHNIY'|
                         'MATANZAS, VENEZUELA'|
                         'BAHRAIN'|
                         'PORTO MARGHERA'|
                         'PORT HARCOURT-ONNE'|
                         '1SP CHINA'|
                         'TABONEO'|
                         'DURING MONSOON'|
                         'PIETARSAARI(FINLAND)'|
                         'ISKENDERUN'|
                         'RENI'|
                         'BARCELONA';
                         