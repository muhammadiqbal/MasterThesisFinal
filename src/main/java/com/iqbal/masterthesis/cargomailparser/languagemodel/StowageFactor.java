package com.iqbal.masterthesis.cargomailparser.languagemodel;

import com.iqbal.masterthesis.cargomailparser.model.BaseModel;

/**
 * StowageFactor
 */
public class StowageFactor extends BaseModel{
    private float nominal;
    private String unit;
    private boolean approximate;
    
    public StowageFactor(boolean approximate, float nominal, String unit){
        this.modelType = "Stowage Factor";
        this.approximate = approximate;
        this.nominal = nominal;
        this.unit = unit;
    }

    public StowageFactor(boolean approximate, float nominal) {
        this.approximate = approximate;
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
     * @return the nominal
     */
    public float getNominal() {
        return nominal;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param nominal the nominal to set
     */
    public void setNominal(float nominal) {
        this.nominal = nominal;
    }
    
    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}