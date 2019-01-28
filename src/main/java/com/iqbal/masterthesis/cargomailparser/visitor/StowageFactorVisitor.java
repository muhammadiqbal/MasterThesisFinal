package com.iqbal.masterthesis.cargomailparser.visitor;

import com.iqbal.masterthesis.cargomailparser.StowageFactorBaseVisitor;
import com.iqbal.masterthesis.cargomailparser.StowageFactorParser.Stowage_factorContext;
import com.iqbal.masterthesis.cargomailparser.languagemodel.StowageFactor;

/**
 * StowageFactorVisitor
 */
public class StowageFactorVisitor extends StowageFactorBaseVisitor<StowageFactor>{

    @Override
    public StowageFactor visitStowage_factor(Stowage_factorContext ctx) {
        boolean approximate = false;
        float nominal = 0;
        if (ctx.STOWAGE_FACTOR_NOMINAL() != null) {
            nominal = Float.parseFloat(ctx.STOWAGE_FACTOR_NOMINAL().getText().replaceAll("[,]", "."));
        }
        if (ctx.STOWAGE_FACTOR_ABOUT() != null) {
            approximate = true;
        }
        if (ctx.STOWAGE_FACTOR_UNIT()!= null) {
            String unit = ctx.STOWAGE_FACTOR_UNIT().getText();  
            return new StowageFactor(approximate, nominal, unit);  
        }else{
            return new StowageFactor(approximate, nominal);
        }
    }

    
}