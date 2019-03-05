package com.iqbal.masterthesis.cargomailparser.languagemodel;

import com.iqbal.masterthesis.cargomailparser.model.BaseModel;

/**
 * Quantity
 */
public class Quantity extends BaseModel{

    private int nominal;
    private String units;

    public Quantity(int nominal, String units) {
        this.modelType = "Quantity";
        this.units = units;
        if (units.matches("kg*.")) {
            this.nominal = nominal/1000;
        }
        else{
            // check wheter the quantity detected is in form of digit folowed by K
            // or a range e.g 10/11000 (in this case 10 will be detected)
            // then reformat 
            if(nominal/100 == 0)
                nominal *= 1000;
            this.nominal = nominal;
        }
    }
    /**
     * @param nominal the nominal to set
     */
    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     * @return the nominal
     */
    public int getNominal() {
        return nominal;
    }
    /**
     * @return the units
     */
    public String getUnits() {
        return units;
    }
}