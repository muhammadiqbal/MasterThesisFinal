package com.iqbal.masterthesis.cargomailparser.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import com.iqbal.masterthesis.cargomailparser.*;
import com.iqbal.masterthesis.cargomailparser.PortDestinationLexer;
import com.iqbal.masterthesis.cargomailparser.PortDestinationParser;
import com.iqbal.masterthesis.cargomailparser.StowageFactorLexer;
import com.iqbal.masterthesis.cargomailparser.StowageFactorParser;
import com.iqbal.masterthesis.cargomailparser.helper.Preprocessor;
import com.iqbal.masterthesis.cargomailparser.visitor.*;
import com.iqbal.masterthesis.cargomailparser.visitor.LDRateVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.StowageFactorVisitor;
import com.iqbal.masterthesis.cargomailparser.languagemodel.*;
import com.iqbal.masterthesis.cargomailparser.service.ParseService;
import com.iqbal.masterthesis.cargomailparser.service.PythonRunnerService;
import com.iqbal.masterthesis.cargomailparser.service.TestDataService;
import com.iqbal.masterthesis.cargomailparser.model.Cargo;
import com.iqbal.masterthesis.cargomailparser.model.Email;
import com.iqbal.masterthesis.cargomailparser.repositories.CargoRepository;
import com.iqbal.masterthesis.cargomailparser.repositories.EmailRepository;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ParseController
 */
@RestController
@RequestMapping("/api")
public class ParseController {

    @Autowired
    EmailRepository emailRepo;

    @Autowired
    CargoRepository cargoRepo;

    @GetMapping(value = "parse")
    public Cargo getParse(@RequestParam("input") String email) throws ClassNotFoundException, IOException {
                
        long startTime = System.nanoTime();
        /* ... the code being measured starts ... */
        Cargo cargo = ParseService.parseEmailNoClassifiation(email);
        /* ... the code being measured ends ... */
        long endTime = System.nanoTime();

        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;  
        saveParsingEntity(email, cargo, timeElapsed/1000000);
        return cargo;
    }

    @GetMapping(value = "test")
    public Cargo getMethodName() throws ClassNotFoundException, IOException {
        String email = TestDataService.getEmail();
                
        long startTime = System.nanoTime();
        /* ... the code being measured starts ... */
        Cargo cargo = ParseService.parseEmailNoClassifiation(email);
        /* ... the code being measured ends ... */
        long endTime = System.nanoTime();

        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;  
        saveParsingEntity(email, cargo, timeElapsed/1000000);
        return cargo;
    }

    @PostMapping(value = "parse")
    public Cargo postMethodName(@RequestParam("input") String email)
            throws ClassNotFoundException, IOException, InterruptedException {
                
        long startTime = System.nanoTime();
        /* ... the code being measured starts ... */
        Cargo cargo = ParseService.parseEmailNoClassifiation(email);;
        /* ... the code being measured ends ... */
        long endTime = System.nanoTime();

        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;  
        saveParsingEntity(email, cargo, timeElapsed/1000000);
        System.out.println(email);
        return cargo;
    }

    @GetMapping(value = "parsesf")
    public StowageFactor getMethodName(@RequestParam("input") String param) {
        CharStream inputStream = CharStreams.fromString(param);
        StowageFactorLexer lexer4 = new StowageFactorLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer4);
        StowageFactorParser stowageFactorParser = new StowageFactorParser(commonTokenStream);
        StowageFactorVisitor stowageFactorVisitor = new StowageFactorVisitor();
        return stowageFactorVisitor.visitStowage_factor(stowageFactorParser.stowage_factor());
    }

    @GetMapping(value = "path")
    public Quantity getMethodNames() {
        Quantity quantity = ParseService.parseQuantity(
                "No.: 149823 \r\nPh.: 00386 5 6626555 \r\nMob.: 00386 41 337250 (Borut)\r\n 00386 31 345270 (Ales)\r\n00386 41 932483 (Matej) \r\n00386 41 338827 (Igor) \r\nFax: 00386 5 6626550 \r\nE-mail: bluemarine@bluemarine-ltd.com\r\n\r\n");
        return quantity;
    }

    @GetMapping(value = "parsePort")
    public PortDestination getPort() {
        String inputString = "FM: U N I M A R SERVICE LTD, CYPRUS \n"+
        "EMAIL: chartering@unimarservice.com\n"+
        "***********************************\n"+
        "IMPORTANT NOTICE => IT'S REGULAR MAIL OF SHIPPING BUSINESS, POSSIBLE DUPLICATE.\n"+
        "K. ATTN: CHARTERING DESK\n"+
        "COULD YOU KINDLY ADD/KEEP ONLY OUR EMAIL chartering@unimarservice.com IN YRS CIRCULARS.\n"+
        "FOR SUBSCRIBE YRS EMAIL IN OUR UPGRADED CIRCULATION SYSTEM PLEASE VISIT WWW.UNIMARSERVICE.COM\n"+
        "COULD YOU KINDLY OFFER FIRM:\n"+
        "Vlissingen -> Murmansk - 10/11000 mts iron ore\n"+
        "Lay/can: 29-30th June\n"+
        "36 hrs sshex  / 48 hrs sshinc\n"+
        "5.0% ttl comm here";
        CharStream input = CharStreams.fromString(inputString);
        PortDestinationLexer portDestinationLexer = new PortDestinationLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(portDestinationLexer);
        PortDestinationParser portDestinationParser = new PortDestinationParser(commonTokenStream);
        PortVisitor portVisitor = new PortVisitor();

        // System.out.println(portDestinationParser.port_destination().getText());
        // System.out.println(portDestinationParser.port_destination().PORT_FROM().getText());
        // System.out.println(portDestinationParser.port_destination().PORT_SIGN().getText());
        // System.out.println(portDestinationParser.port_destination().PORT_TO().getText());
        PortDestination portDestination = portVisitor.visitPort_destination(portDestinationParser.port_destination());
        return portDestination;

    }

    @GetMapping(value = "parseldr")
    public LDRate getLDRate(@RequestParam String param) {
        CharStream input = CharStreams.fromString("-L/D RATE:2000/800MT PWWD SHINC ");
        LDRateLexer ldRateLexer = new LDRateLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(ldRateLexer);
        LDRateParser ldRateParser = new LDRateParser(commonTokenStream);
        LDRateVisitor ldRateVisitor = new LDRateVisitor();
        LDRate ldRate = ldRateVisitor.visitLoading_discharging_rate(ldRateParser.loading_discharging_rate());
        return ldRate;
    }

    @GetMapping(value = "testpreprocessor")
    public List<String> testPre() throws ClassNotFoundException {
        String text = TestDataService.getEmail();
        List<String> result = Preprocessor.textIntoSentences(text);
        return result;
    }

    @GetMapping(value = "testpython")
    public String testpython() throws IOException {
        String result = PythonRunnerService.runClassifier("test");
        return result;
    }

    @GetMapping(value = "testSF")
    public StowageFactor testSF() {
        StowageFactor stowageFactor = ParseService
                .parseStowageFactor("QUY NHON -> JINGTANG - 15,000 MT 10% BULK TAPIOCA CHIP S.F 2.1 WOG");
        return stowageFactor;
    }

    private void saveParsingEntity(String inputEmail, Cargo cargo, Long parsingTimeMs) {
        cargo.setParsingTime(parsingTimeMs);
        cargo = cargoRepo.save(cargo);
        Email email = new Email(cargo);
        email.setBody(inputEmail);
        emailRepo.save(email);
        email.setParsingTimeMiliSecond(parsingTimeMs);
    }
}