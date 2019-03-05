package com.iqbal.masterthesis.cargomailparser.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * TestDataService
 */
public class TestDataService {

    public static String getEmail() throws ClassNotFoundException {
        String result = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpsbulkcargo", "root", "root");
            Statement stmt = con.createStatement();
            String query = "SELECT body FROM email WHERE classification_automated = 'Cargo' AND char_length(body) > 0 ORDER BY rand() LIMIT 1;";
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            result = rs.getString(1);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getLine() throws ClassNotFoundException {
        String result = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/email", "root", "root");
            Statement stmt = con.createStatement();
            String query = "SELECT line FROM emailLines_new ORDER BY rand() LIMIT 1;";
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            result = rs.getString(1);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}