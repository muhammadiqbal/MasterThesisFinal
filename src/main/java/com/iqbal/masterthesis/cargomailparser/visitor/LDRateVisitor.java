package com.iqbal.masterthesis.cargomailparser.visitor;

import com.iqbal.masterthesis.cargomailparser.LDRateBaseVisitor;
import com.iqbal.masterthesis.cargomailparser.LDRateParser.Discharging_rateContext;
import com.iqbal.masterthesis.cargomailparser.LDRateParser.Loading_discharging_rateContext;
import com.iqbal.masterthesis.cargomailparser.LDRateParser.Loading_rateContext;
import com.iqbal.masterthesis.cargomailparser.languagemodel.LDRate;

/**
 * LDRateVisitor
 */
public class LDRateVisitor extends LDRateBaseVisitor<LDRate> {
    @Override
    public LDRate visitLoading_discharging_rate(Loading_discharging_rateContext ctx) {
        float dischargingRate = 0;
        float loadingRate = 0;
        
        //validate the parsed entities 
        //if the entities found is not complete return null
        if(ctx.RATE_NOMINAL().size()<1 || ctx.RATE_TYPE().size()<1 )
            return null;

        // get the first occurence ofloading discharing rate
        loadingRate = Float.parseFloat(ctx.RATE_NOMINAL().get(0).getText().replaceAll("[.,]", ""));
        // if there's only one loading rate type found assume both value are same
        dischargingRate = loadingRate;
        if(ctx.RATE_NOMINAL().size()>1){
            dischargingRate = Float.parseFloat(ctx.RATE_NOMINAL().get(1).getText().replaceAll("[.,]", ""));
        }

        String loadingRateType = ctx.RATE_TYPE().get(0).getText();
        // if there's only one declaration of rate type get the first occurence as a default
        String dischargingRateType = loadingRateType;

        // there are more than one declaration of rate type 
        // set the dischargng rate as the second occurence 
        if(ctx.RATE_TYPE().size() > 1 ){
            dischargingRateType = ctx.RATE_TYPE().get(1).getText();
        }
        return new LDRate(loadingRate, dischargingRate, loadingRateType, dischargingRateType);
    }

    // @Override
    // public LDRate visitLoading_discharging_rate(Loading_discharging_rateContext ctx) {
    //     float dischargingRate = 0;
    //     float loadingRate = 0;
        
    //     //validate the parsed entities 
    //     //if the entities found is not complete return null
    //     if(ctx.RATE_NOMINAL() == null || ctx.RATE_TYPE() == null )
    //         return null;

    //     // get the first occurence ofloading discharing rate
    //     loadingRate = Float.parseFloat(ctx.RATE_NOMINAL().getText().replaceAll("[.,]", ""));
    //     if(ctx.RATE_NOMINAL() != null)
    //         dischargingRate = Float.parseFloat(ctx.RATE_NOMINAL().getText().replaceAll("[.,]", ""));
    //     String loadingRateType = ctx.RATE_TYPE().getText();
        
    //     // there's only one declaration of rate type get the first occurence as a default
    //     String dischargingRateType = loadingRateType;

    //     // there are more than one declaration of rate type 
    //     // set the dischargng rate as the second occurence 
        
    //         dischargingRateType = ctx.RATE_TYPE().getText();
    //     return new LDRate(loadingRate, dischargingRate, loadingRateType, dischargingRateType);
    // }

    @Override
    public LDRate visitLoading_rate(Loading_rateContext ctx) {
        return super.visitLoading_rate(ctx);
    }

    @Override
    public LDRate visitDischarging_rate(Discharging_rateContext ctx) {
        return super.visitDischarging_rate(ctx);
    }
    
}