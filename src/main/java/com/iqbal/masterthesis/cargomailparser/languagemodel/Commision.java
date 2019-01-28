package com.iqbal.masterthesis.cargomailparser.languagemodel;

import com.iqbal.masterthesis.cargomailparser.model.BaseModel;

/**
 * Commision
 */
public class Commision extends BaseModel {

    private boolean approximate;
    private float nominal;
    private String type;

    public Commision(boolean approximate, float nominal){
        this.approximate = approximate;
        this.nominal = nominal;
        this.modelType = "Commision";
    }

    public Commision(boolean approximate, float nominal, String type){
        this.approximate = approximate;
        this.nominal = nominal;
        this.type = type;
    }

    public Commision(float nominal){
        this.approximate = false;
        this.nominal = nominal;
    }

    /**
     * @return the approximate
     */
    public boolean isApproximate() {
        return approximate;
    }

    /**
     * @param approximate the approximate to set
     */
    public void setApproximate(boolean approximate) {
        this.approximate = approximate;
    }
    
    /**
     * @param nominal the nominal to set
     */
    public void setNominal(float nominal) {
        this.nominal = nominal;
    }

    /**
     * @return the nominal
     */
    public float getNominal() {
        return nominal;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}