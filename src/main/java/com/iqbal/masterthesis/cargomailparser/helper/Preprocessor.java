package com.iqbal.masterthesis.cargomailparser.helper;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Preprocessor
 */
public class Preprocessor {

    public static List<String> textIntoSentences(String text) {
        List<String> sentences = new ArrayList<String>();
        String[] subtexts = null;
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(text);
        int start = iterator.first();
        
        //split the text into subtext
        for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
            //split the subtext by new line
            subtexts = splitTextByNewLine(text.substring(start, end));
            for (String line : subtexts) {
                //if the line is not an empty string then add it to the list of sentences
                if(!line.isEmpty())
                sentences.add(line);
            }
        }
        return sentences;
    }

    //this function is created to improve code readability and reusability
    public static String[] splitTextByNewLine(String text) {
        String lines[] = text.split("\\r?\\n"); 
        return lines;   
    }
    
}