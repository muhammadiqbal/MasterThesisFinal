package com.iqbal.masterthesis.cargomailparser.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.iqbal.masterthesis.cargomailparser.*;
import com.iqbal.masterthesis.cargomailparser.helper.Preprocessor;
import com.iqbal.masterthesis.cargomailparser.visitor.*;
import com.iqbal.masterthesis.cargomailparser.visitor.CommisionVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.DescriptionVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.LDRateVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.LaycanDateVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.QuantityVisitor;
import com.iqbal.masterthesis.cargomailparser.visitor.StowageFactorVisitor;
import com.iqbal.masterthesis.cargomailparser.languagemodel.*;
import com.iqbal.masterthesis.cargomailparser.model.BaseModel;
import com.iqbal.masterthesis.cargomailparser.model.Cargo;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * ParseService
 */
public class ParseService {
    
    public static Cargo parseEmail(String email) throws IOException {
        List<String> lines = Preprocessor.textIntoSentences(email);
        Cargo cargo = new Cargo();
        for (String line : lines) {
            String textClass = PythonRunnerService.runClassifier(line); 
            if (textClass!= null) {
                switch (textClass) {
                    case "LD rate":
                        cargo.setLDRate(parseLDrate(line));
                    case "Quantity":
                        cargo.setQuantity(parseQuantity(line).getNominal());
                    case "Laycan Date":
                        cargo.setLaycanDate(parseLaycanDate(line));
                    case "Port":
                        cargo.setPortDestination(parsePortDestination(line));
                    case "Commision":
                        cargo.setCommision(parseCommision(line).getNominal());
                    case "Stowage Factor":
                        cargo.setStowage_factor(parseStowageFactor(line).getNominal());
                    default:
                        break;
                }
            }
        }       
        
        return cargo;
    }

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
        PortDestinationLexer portDestinationLexer = new PortDestinationLexer(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(portDestinationLexer);
        PortDestinationParser portDestinationParser = new PortDestinationParser(commonTokenStream);
        PortVisitor portVisitor = new PortVisitor();
        PortDestination portDestination = portVisitor.visitPort_destination(portDestinationParser.port_destination());
        return portDestination;
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

    // public static List<Commision> parseCommisions(String inputStream) {
    //     CharStream input = CharStreams.fromString(inputStream);
    //     CommisionLexer lexer = new CommisionLexer(input);
    //     CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
    //     CommisionParser commisionParser = new CommisionParser(commonTokenStream);
    //     CommisionVisitor commisionVisitor = new CommisionVisitor();
    //     List<Commision> commisions = commisionVisitor.visitCommisions(commisionParser.commision());
    //     return commisions;
    // }

        // public static List<Description> parseDescriptions(String inputStream) {
    //     CharStream input = CharStreams.fromString(inputStream);
    //     DescriptionLexer lexer3 = new DescriptionLexer(input);
    //     CommonTokenStream commonTokenStream3 = new CommonTokenStream(lexer3);
    //     DescriptionParser descriptionParser = new DescriptionParser(commonTokenStream3);
    //     DescriptionVisitor descriptionVisitor = new DescriptionVisitor();
    //     List<Description> descriptions = descriptionVisitor.visitDescriptions(descriptionParser.description());
    //     return descriptions;
    // }

    // public static Description parseDescription(String inputStream) {
    //     CharStream input = CharStreams.fromString(inputStream);
    //     QuantityLexer lexer = new QuantityLexer(input);
    //     CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
    //     QuantityParser quantityParser = new QuantityParser(commonTokenStream);
    //     QuantityVisitor quantityVisitor = new QuantityVisitor();
    //     Description description = quantityVisitor.visitDescription(quantityParser.quantity());
    //     return description;
    // }

    // public static List<Quantity> parseQuantities(String inputStream) {
    //     CharStream input = CharStreams.fromString(inputStream);
    //     QuantityLexer lexer = new QuantityLexer(input);
    //     CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
    //     QuantityParser quantityParser = new QuantityParser(commonTokenStream);
    //     QuantityVisitor quantityVisitor = new QuantityVisitor();
    //     List<Quantity> quantities = quantityVisitor.visitQuantities(quantityParser.quantity());
    //     return quantities;
    // }

}