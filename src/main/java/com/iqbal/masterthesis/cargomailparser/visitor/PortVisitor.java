package com.iqbal.masterthesis.cargomailparser.visitor;

import com.iqbal.masterthesis.cargomailparser.PortDestinationBaseVisitor;
import com.iqbal.masterthesis.cargomailparser.PortDestinationParser.Discharging_portContext;
import com.iqbal.masterthesis.cargomailparser.PortDestinationParser.Loading_portContext;
import com.iqbal.masterthesis.cargomailparser.PortDestinationParser.Port_destinationContext;
import com.iqbal.masterthesis.cargomailparser.languagemodel.PortDestination;;

/**
 * PortVisitor
 */
public class PortVisitor extends PortDestinationBaseVisitor<PortDestination> {
    

    public PortDestination visitPort_destination(Port_destinationContext ctx) {
        String loadingPort = null;
        String dischargingPort = null;
        PortDestination portDestination = new PortDestination();
        if(ctx.PORT_FROM() != null){
            loadingPort = ctx.PORT_FROM().getText();
            portDestination.setPortFrom(loadingPort);
        }else if(ctx.PORT() != null){
            loadingPort = ctx.PORT().getText();
        }
        if(ctx.PORT_TO() != null){
            portDestination.setPortTo(dischargingPort);
        }else if(ctx.PORT() != null){
            loadingPort = ctx.PORT().getText();
        }
        return portDestination;
    }

    
    public PortDestination visitLoading_port(Loading_portContext ctx, PortDestination portDestination) {
        String loadingPort = null;
        if(ctx.PORT_FROM() != null){
            loadingPort = ctx.PORT_FROM().getText();    
        }
        portDestination.setPortFrom(loadingPort);
        return portDestination;
    }

    public PortDestination visitDischarging_port(Discharging_portContext ctx, PortDestination portDestination){
        String dischargingPort = null;
        if(ctx.PORT() != null){
            dischargingPort = ctx.PORT().getText();    
        }
        portDestination.setPortFrom(dischargingPort);
        return portDestination;
    }
}