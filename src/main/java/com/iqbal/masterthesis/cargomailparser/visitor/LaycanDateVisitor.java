package com.iqbal.masterthesis.cargomailparser.visitor;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.iqbal.masterthesis.cargomailparser.LaycanDateBaseVisitor;
import com.iqbal.masterthesis.cargomailparser.LaycanDateParser.LaycanContext;
import com.iqbal.masterthesis.cargomailparser.languagemodel.LaycanDate;

/**
 * LaycanDateVisitor
 */
public class LaycanDateVisitor extends LaycanDateBaseVisitor<LaycanDate> {
    
    @Override
    public LaycanDate visitLaycan(LaycanContext ctx) {
        Date laycanFirstDay = null;
        Date laycanLastDay = null;
        SimpleDateFormat dateParser = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        if (ctx.FIRST_DAY() != null && ctx.DATE_MONTH() != null) {
            if (ctx.DATE_YEAR() != null) {
                try {
                    
                    laycanFirstDay = dateParser.parse(ctx.FIRST_DAY().getText() + "/" + ctx.DATE_MONTH().getText() + "/"
                            + ctx.DATE_YEAR().getText());
                    System.out.println(laycanFirstDay);
                    System.out.println(ctx.FIRST_DAY().getText());
                    System.out.println(ctx.DATE_MONTH().getText());
                } catch (ParseException e) {
                   
                    e.printStackTrace();
                }
            } else {
                try {
                    laycanFirstDay = dateParser.parse(ctx.FIRST_DAY().getText() + "/" + ctx.DATE_MONTH().getText() + "/" + year);
                    System.out.println(laycanFirstDay);
                    System.out.println(ctx.FIRST_DAY().getText());
                    System.out.println(ctx.DATE_MONTH().getText());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        if (ctx.LAST_DAY() != null && ctx.DATE_MONTH() != null) {
            if (ctx.DATE_YEAR()!= null) {
                try {
                    laycanLastDay = dateParser.parse(ctx.LAST_DAY().getText() + "/" + ctx.DATE_MONTH().getText() + "/"
                            + ctx.DATE_YEAR().getText());
                    System.out.println(laycanLastDay);
                    System.out.println(ctx.LAST_DAY().getText());
                    System.out.println(ctx.DATE_MONTH().getText());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    laycanFirstDay = dateParser.parse(ctx.LAST_DAY().getText() + "/" + ctx.DATE_MONTH().getText() + "/" + year);
                    System.out.println(laycanLastDay);
                    System.out.println(ctx.LAST_DAY().getText());
                    System.out.println(ctx.DATE_MONTH().getText());
                } catch (ParseException e) {
                     
                    e.printStackTrace();
                }
            }
            
        }
        System.out.println(laycanFirstDay);
        System.out.println(laycanLastDay);
        return new LaycanDate(laycanFirstDay, laycanLastDay);
    }
}