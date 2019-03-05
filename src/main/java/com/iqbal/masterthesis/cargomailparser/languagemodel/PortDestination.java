package com.iqbal.masterthesis.cargomailparser.languagemodel;

import com.iqbal.masterthesis.cargomailparser.model.BaseModel;

/**
 * PortDesination
 */
public class PortDestination extends BaseModel{
    private String portFrom;
    private String portTo;

    public PortDestination() {
    }
    public PortDestination(String portFrom, String portTo) {
        this.portFrom = portFrom;
        this.portTo = portTo;
        this.modelType = "Port Destination";
    }

    /**
     * @return the portFrom
     */
    public String getPortFrom() {
        return portFrom;
    }
    /**
     * @return the portTo
     */
    public String getPortTo() {
        return portTo;
    }
    /**
     * @param portFrom the portFrom to set
     */
    public void setPortFrom(String portFrom) {
        this.portFrom = portFrom;
    }
    /**
     * @param portTo the portTo to set
     */
    public void setPortTo(String portTo) {
        this.portTo = portTo;
    }
    
}