package com.iqbal.masterthesis.cargomailparser.visitor;

import com.iqbal.masterthesis.cargomailparser.PortDestinationBaseVisitor;
import com.iqbal.masterthesis.cargomailparser.PortDestinationParser.Port_destinationContext;
import com.iqbal.masterthesis.cargomailparser.languagemodel.PortDestination;;

/**
 * PortVisitor
 */
public class PortVisitor extends PortDestinationBaseVisitor<PortDestination> {
    

    public PortDestination visitPort_destination(Port_destinationContext ctx) {
        String loadingPort = null;
        String dischargingPort = null;
        PortDestination portDestination = null;
        if(ctx.PORT_FROM() != null){
            loadingPort = ctx.PORT_FROM().getText();
        }
        if(ctx.PORT_TO() != null){
            dischargingPort = ctx.PORT_FROM().getText();
        }
        if ((loadingPort != null) && (dischargingPort != null)) {
            portDestination = new PortDestination(loadingPort, dischargingPort);
        }
        return portDestination;
    }
    
}