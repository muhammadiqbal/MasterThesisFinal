package com.iqbal.masterthesis.cargomailparser.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PythonRunnerService
 */
public class PythonRunnerService {
    public static String run(String pythonFile, String args) {
        String command = "python";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command +" "+ pythonFile +" "+args);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return process.getOutputStream().toString();
    }

    public static String runClassifier(String args) throws IOException {
        String[] command = {"python3","python/classifier/classifier.py",args};
        Process process = null;
        String output = "None";
        BufferedReader stdInput = null;
        BufferedReader stdError = null;
        try {
            process = Runtime.getRuntime().exec(command);
            stdInput = new BufferedReader(new 
                 InputStreamReader(process.getInputStream()));

            stdError = new BufferedReader(new 
                 InputStreamReader(process.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:");
            while ((output = stdInput.readLine()) != null) {
                output = stdInput.readLine();
            }    
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            while ((output = stdError.readLine()) != null) {
                System.out.println(output);
            } 
            e.printStackTrace();
            System.exit(-1);
        }
        return output;
    }

    // public static String runClassifierJython(String args) {
    //     Properties props = new Properties();
    //     props.put("python.home","target/classes/Lib");
    //     props.put("python.console.encoding", "UTF-8"); // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
    //     props.put("python.security.respectJavaAccessibility", "false"); //don't respect java accessibility, so that we can access protected members on subclasses
    //     props.put("python.import.site","false");

    //     Properties preprops = System.getProperties();
                
    //     PythonInterpreter.initialize(preprops, props, new String[0]);
    //     PythonInterpreter python = new PythonInterpreter();
        
    //     python.exec("from sklearn.externals import joblib");
    //     python.exec("import sys");
    //     python.exec("model = joblib.load('classfier/model_emailLines_class_uncleaned.pkl')");
    //     python.exec("class = model.predict(["+args+"])[0]");
        
    //     String output = python.get("class").toString();
    //     python.close();
    //     return output;   
    // }
}