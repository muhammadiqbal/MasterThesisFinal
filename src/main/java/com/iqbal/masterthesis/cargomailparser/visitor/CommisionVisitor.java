package com.iqbal.masterthesis.cargomailparser.visitor;

import com.iqbal.masterthesis.cargomailparser.CommisionBaseVisitor;
import com.iqbal.masterthesis.cargomailparser.CommisionParser.CommisionContext;
import com.iqbal.masterthesis.cargomailparser.languagemodel.Commision;

/**
 * CommisionVisitor
 */
public class CommisionVisitor extends CommisionBaseVisitor<Commision> {
    @Override
    public Commision visitCommision(CommisionContext ctx) {
        boolean approx = false;
        float nominal = 0;
        Commision commision = null;
        if (ctx.COMMISION_ABOUT() != null) {
            approx = true;
        }
        if (ctx.COMMISION_NOMINAL() != null) {
            nominal = Float.parseFloat(ctx.COMMISION_NOMINAL().getText().replaceAll("[,]", "."));
        }
        if (nominal != 0 && ctx.COMMISION_TYPE() != null) {
            commision = new Commision(approx, nominal);
        }
        return commision;
    }



    // public List<Commision> visitCommisions(CommisionContext ctx) {
    //     boolean approx=false;
    //     float nominal;

    //     List<Commision> commisions = new ArrayList<Commision>();
    //     List<TerminalNode> commisionNominals = ctx.COMMISION_NOMINAL();
    //     List<TerminalNode> commisionAbouts = ctx.COMMISION_ABOUT();
    //     List<TerminalNode> commisionTypes = ctx.COMMISION_TYPE();

    //     for (int i = 0; i < commisionNominals.size(); i++) {
    //         if (i < commisionAbouts.size()) {
    //             approx = StringUtils.isEmpty(commisionAbouts.get(i).getText());
    //         }
    //         nominal = Float.parseFloat(commisionNominals.get(i).getText().replaceAll("[,]", "."));
    //         if (i < commisionTypes.size()) {
    //             commisions.add(new Commision(approx, nominal, commisionTypes.get(i).getText()));
    //         } else {
    //             commisions.add(new Commision(approx, nominal));    
    //         }
    //     }
    //     return commisions;
    // }
}