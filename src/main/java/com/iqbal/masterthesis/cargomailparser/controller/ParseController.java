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
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ParseController
 */
@RestController
@RequestMapping("/api")
public class ParseController {

    @GetMapping(value = "parse")
    public StowageFactor getMethodName(@RequestParam("input") String param) {
        CharStream inputStream = CharStreams.fromString(param);
        StowageFactorLexer lexer4 = new StowageFactorLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer4);
        StowageFactorParser stowageFactorParser = new StowageFactorParser(commonTokenStream);
        StowageFactorVisitor stowageFactorVisitor = new StowageFactorVisitor();
        return stowageFactorVisitor.visitStowage_factor(stowageFactorParser.stowage_factor());
    }

    @GetMapping(value="path")
    public Quantity getMethodNames() {
        Quantity quantity = ParseService.parseQuantity("No.: 149823 \r\nPh.: 00386 5 6626555 \r\nMob.: 00386 41 337250 (Borut)\r\n 00386 31 345270 (Ales)\r\n00386 41 932483 (Matej) \r\n00386 41 338827 (Igor) \r\nFax: 00386 5 6626550 \r\nE-mail: bluemarine@bluemarine-ltd.com\r\n\r\n");
        return quantity;
    }
    

    @GetMapping(value="parsePort")
    public PortDestination getPort(@RequestParam String param) {
        CharStream input = CharStreams.fromString("THESSALONIKI,GREECE -> KWANGYANG,KOREA");
        PortDestinationLexer portDestinationLexer = new PortDestinationLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(portDestinationLexer);
        PortDestinationParser portDestinationParser = new PortDestinationParser(commonTokenStream);
        PortVisitor portVisitor = new PortVisitor();

        System.out.println(portDestinationParser.port_destination().getText());
        System.out.println(portDestinationParser.port_destination().PORT_FROM().getText());
        System.out.println(portDestinationParser.port_destination().PORT_SIGN().getText());
        //System.out.println(portDestinationParser.port_destination().PORT_TO().getText());
        PortDestination portDestination = portVisitor.visitPort_destination(portDestinationParser.port_destination());
        return portDestination;

    }

    @GetMapping(value="parseldr")
    public LDRate getLDRate(@RequestParam String param) {
        CharStream input = CharStreams.fromString("-L/D RATE:2000/800MT PWWD SHINC ");
        LDRateLexer ldRateLexer = new LDRateLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(ldRateLexer);
        LDRateParser ldRateParser = new LDRateParser(commonTokenStream);
        LDRateVisitor ldRateVisitor = new LDRateVisitor();
        LDRate ldRate = ldRateVisitor.visitLoading_discharging_rate(ldRateParser.loading_discharging_rate());
        return ldRate;
    }
    
    @GetMapping(value="test")
    public Cargo getMethodName() throws ClassNotFoundException, IOException {
        String testInput = TestDataService.getEmail();
        //System.out.println(testInput);
        //Cargo cargo = ParseService.parseEmail(testInput);
        Cargo cargo = ParseService.parseEmailNoClassifiation(testInput);
        System.out.println(testInput);
        return cargo;
    }

    @GetMapping(value="testpreprocessor")
    public List<String> testPre() throws ClassNotFoundException {
        String text =  TestDataService.getEmail();
        List<String> result = Preprocessor.textIntoSentences(text); 
        return result;
    }
    
    @GetMapping(value="testpython")
    public String testpython() throws IOException {
        String result = PythonRunnerService.runClassifier("test");
        return result;
    }

    @GetMapping(value="testSF")
    public StowageFactor testSF() {
        StowageFactor stowageFactor = ParseService.parseStowageFactor("QUY NHON -> JINGTANG - 15,000 MT 10% BULK TAPIOCA CHIP S.F 2.1 WOG");
        return stowageFactor;
    }
    
}