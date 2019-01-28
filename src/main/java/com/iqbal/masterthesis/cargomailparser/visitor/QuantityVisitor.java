package com.iqbal.masterthesis.cargomailparser.visitor;

import com.iqbal.masterthesis.cargomailparser.QuantityBaseVisitor;
import com.iqbal.masterthesis.cargomailparser.QuantityParser.QuantityContext;
import com.iqbal.masterthesis.cargomailparser.languagemodel.Quantity;

/**
 * QuantityVisitor
 */
public class QuantityVisitor  extends QuantityBaseVisitor<Quantity> {

    @Override
    public Quantity visitQuantity(QuantityContext ctx) {
        int nominal = 0;
        String units = null;
        Quantity quantity = null;
        if (ctx.QUANTITY_NOMINAL() != null) {
            nominal = Integer.parseInt(ctx.QUANTITY_NOMINAL().getText().replaceAll("[.,`]", ""));
        } 
        if (ctx.QUANTITY_UNIT() != null) {
            units = ctx.QUANTITY_UNIT().getText();
        }
        if ((nominal != 0) && (units != null)) {
            quantity = new Quantity(nominal, units);
        }
        return quantity;
    }    

        // public List<Quantity> visitQuantities(QuantityContext ctx) {
    //     // The length of units List and nominalString list is always the same 
    //     // Both list are required toens for quantity
    //     // every single ocurence of quantity will have unit ad nominal
    //     // The parsing rule is defined in the Quantity.g4 grammar 
    //     List<Quantity> quantities = new ArrayList<Quantity>();
    //     List<TerminalNode> units = ctx.QUANTITY_UNIT();
    //     List<TerminalNode> nominals = ctx.QUANTITY_NOMINAL();
        
    //     for (int i = 0; i < units.size(); i++) {
    //         int nominalInt = Integer.parseInt(nominals.get(i).getText().replaceAll("[.,]", ""));
    //         if (units.get(i) != null){
    //             quantities.add(new Quantity(nominalInt,units.get(i).getText()));
    //         }else{
    //             continue;
    //         }
    //     }
    //     return quantities;
    // }
}