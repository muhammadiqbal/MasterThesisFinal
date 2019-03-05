package com.iqbal.masterthesis.cargomailparser.service;

import java.io.IOException;
import java.util.List;
import com.iqbal.masterthesis.cargomailparser.*;
import com.iqbal.masterthesis.cargomailparser.helper.Preprocessor;
import com.iqbal.masterthesis.cargomailparser.visitor.*;
import com.iqbal.masterthesis.cargomailparser.visitor.CommisionVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.LDRateVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.LaycanDateVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.QuantityVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.StowageFactorVisitor;
import com.iqbal.masterthesis.cargomailparser.languagemodel.*;
import com.iqbal.masterthesis.cargomailparser.model.Cargo;
import com.iqbal.masterthesis.cargomailparser.repositories.CargoRepository;
import com.iqbal.masterthesis.cargomailparser.repositories.EmailRepository;
import com.iqbal.masterthesis.cargomailparser.helper.CaseChangingCharStream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ParseService
 */
public class ParseService {

    @Autowired
    CargoRepository cargoRepo;

    @Autowired 
    EmailRepository emailRepo;

    public static Cargo parseEmailNoClassifiation(String email) throws IOException {
        List<String> lines = Preprocessor.textIntoSentences(email);
        Cargo cargo = new Cargo();

        for (String line : lines) {
            // the second codition is used to disambiguate the quantity and ld rate
            // with an assumption, quntity is always defined first
            if(parseQuantity(line) != null && cargo.getQuantity() == 0){
                cargo.setQuantity(parseQuantity(line).getNominal());
                cargo.setDescription(line);
            }
            if(parseLaycanDate(line) != null){
                cargo.setLaycanDate(parseLaycanDate(line));
            }
            if(parsePortDestination(line) != null){
                cargo.setPortDestination(parsePortDestination(line));
            }

            if(parseCommision(line) != null){
                cargo.setCommision(parseCommision(line).getNominal());
            }
            if(parseLDrate(line) != null){
                cargo.setLDRate(parseLDrate(line));
            }
            if(parseStowageFactor(line) != null)
                cargo.setStowage_factor(parseStowageFactor(line).getNominal());
        }
        if (cargo.getLoading_port() == null && cargo.getDescription() != null) {
            cargo.setLoading_port(findLoadPortInDesc(cargo.getDescription()));
        }

        if (cargo.getDischarging_port() == null && cargo.getDescription() != null) {
            cargo.setDischarging_port(findDischPortInDesc(cargo.getDescription()));
        }
        return cargo;
    }
    
    public static LDRate parseLDrate(String inputStream) {
        CharStream input = CharStreams.fromString(inputStream);
        LDRateLexer ldRateLexer = new LDRateLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(ldRateLexer);
        LDRateParser ldRateParser = new LDRateParser(commonTokenStream);
        LDRateVisitor ldRateVisitor = new LDRateVisitor();
        LDRate ldRate = ldRateVisitor.visitLoading_discharging_rate(ldRateParser.loading_discharging_rate());
        return ldRate;
    }


    public static Commision parseCommision(String inputStream) {
        CharStream input = CharStreams.fromString(inputStream);
        CommisionLexer lexer = new CommisionLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        CommisionParser commisionParser = new CommisionParser(commonTokenStream);
        CommisionVisitor commisionVisitor = new CommisionVisitor();
        Commision commision = commisionVisitor.visitCommision(commisionParser.commision());
        return commision;
    }

    public static StowageFactor parseStowageFactor(String inputStream) {
        CharStream input = CharStreams.fromString(inputStream);
        StowageFactorLexer lexer = new StowageFactorLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        StowageFactorParser stowageFactorParser = new StowageFactorParser(commonTokenStream);
        StowageFactorVisitor stowageFactorVisitor = new StowageFactorVisitor();
        StowageFactor stowageFactor =  stowageFactorVisitor.visitStowage_factor(stowageFactorParser.stowage_factor());
        return stowageFactor;
    }

    public static Quantity parseQuantity(String inputStream) {
        CharStream input = CharStreams.fromString(inputStream);
        QuantityLexer lexer = new QuantityLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        QuantityParser quantityParser = new QuantityParser(commonTokenStream);
        QuantityVisitor quantityVisitor = new QuantityVisitor();
        Quantity quantity = quantityVisitor.visitQuantity(quantityParser.quantity());
        return quantity;
    }

    public static PortDestination parsePortDestination(String inputStream) {
        CharStream input = CharStreams.fromString(inputStream);
        CaseChangingCharStream inputUpper = new CaseChangingCharStream(input, true);
        PortDestinationLexer portDestinationLexer = new PortDestinationLexer(inputUpper);
        CommonTokenStream commonTokenStream = new CommonTokenStream(portDestinationLexer);
        PortDestinationParser portDestinationParser = new PortDestinationParser(commonTokenStream);
        PortVisitor portVisitor = new PortVisitor();
        PortDestination portDestination = portVisitor.visitPort_destination(portDestinationParser.port_destination());
        System.out.println(inputUpper);
        System.out.println(portDestination);
        return portDestination;
    }

    public static PortDestination parseLoadPort(String inputStream, PortDestination portDestination) {
        CharStream input = CharStreams.fromString(inputStream);
        PortDestinationLexer portDestinationLexer = new PortDestinationLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(portDestinationLexer);
        PortDestinationParser portDestinationParser = new PortDestinationParser(commonTokenStream);
        PortVisitor portVisitor = new PortVisitor();
        portDestination = portVisitor.visitLoading_port(portDestinationParser.loading_port());
        return portDestination;
    }

    public static PortDestination parseDischargingPort(String inputStream, PortDestination portDestination) {
        CharStream input = CharStreams.fromString(inputStream);
        PortDestinationLexer portDestinationLexer = new PortDestinationLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(portDestinationLexer);
        PortDestinationParser portDestinationParser = new PortDestinationParser(commonTokenStream);
        PortVisitor portVisitor = new PortVisitor();
        PortDestination dischargingPort = portVisitor.visitDischarging_port(portDestinationParser.discharging_port());
        return dischargingPort;
    }

    public static LaycanDate parseLaycanDate(String inputStream) {
        CharStream input = CharStreams.fromString(inputStream);
        LaycanDateLexer laycanDateLexer = new LaycanDateLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(laycanDateLexer);
        LaycanDateParser laycanDateParser = new LaycanDateParser(commonTokenStream);
        LaycanDateVisitor laycanDateVisitor = new LaycanDateVisitor();
        LaycanDate laycanDate = laycanDateVisitor.visitLaycan(laycanDateParser.laycan());
        return laycanDate;
    }

    private static String findLoadPortInDesc(String description){
        String loadPort = null;
        int endIndex = description.indexOf("->");
        if(endIndex > 0)
            loadPort = description.substring(0,endIndex);
        return loadPort;
    }

    private static String findDischPortInDesc(String description){
        String loadPort = null;
        int beginIndex = description.indexOf("->");
        if(beginIndex >0)
            description = description.substring(beginIndex + 3, description.length()-1);
        System.out.println(description);
        int endIndex = description.indexOf("-");
        if(endIndex > 0 && beginIndex >0)
            loadPort = description.substring(0,endIndex);
        return loadPort;
    }
}