package com.iqbal.masterthesis.cargomailparser.languagemodel;

import com.iqbal.masterthesis.cargomailparser.model.BaseModel;

/**
 * LDRate
 */
public class LDRate extends BaseModel {
    private float loadingRate;
    private float dischargingRate;
    private String loadingRateType;
    private String dischargingRateType;

    public LDRate(float loadingRate, float dischargingRate, 
                  String loadingRateType, String dischargingRateType){
        this.loadingRate = loadingRate;
        this.dischargingRate = dischargingRate;
        this.loadingRateType = loadingRateType;
        this.dischargingRateType = dischargingRateType;
        this.modelType = "LDRate";
    }
	/**
     * @return the dischargingRate
     */
    public float getDischargingRate() {
        return dischargingRate;
    }

    /**
     * @return the loadingRate
     */
    public float getLoadingRate() {
        return loadingRate;
    }

    /**
     * @param dischargingRate the dischargingRate to set
     */
    public void setDischargingRate(float dischargingRate) {
        this.dischargingRate = dischargingRate;
    }

    /**
     * @param loadingRate the loadingRate to set
     */
    public void setLoadingRate(float loadingRate) {
        this.loadingRate = loadingRate;
    }

    /**
     * @param loadingRateType the loadingRateType to set
     */
    public void setLoadingRateType(String loadingRateType) {
        this.loadingRateType = loadingRateType;
    }

    /**
     * @param dischargingRateType the dischargingRateType to set
     */
    public void setDischargingRateType(String dischargingRateType) {
        this.dischargingRateType = dischargingRateType;
    }

    /**
     * @return the dischargingRateType
     */
    public String getDischargingRateType() {
        return dischargingRateType;
    }

    /**
     * @return the loadingRateType
     */
    public String getLoadingRateType() {
        return loadingRateType;
    }
    
}