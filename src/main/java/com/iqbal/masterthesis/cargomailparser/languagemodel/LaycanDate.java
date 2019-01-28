package com.iqbal.masterthesis.cargomailparser.languagemodel;

import java.util.Date;

import com.iqbal.masterthesis.cargomailparser.model.BaseModel;

/**
 * LaycanDate
 */
public class LaycanDate extends BaseModel {
    private Date laycanFirstDay;
    private Date laycanLastDay;

    public LaycanDate(Date laycanFirstDay, Date laycanLastDay) {
        this.laycanFirstDay = laycanFirstDay;
        this.laycanLastDay = laycanLastDay;
        this.modelType = "Laycan Date";
    }

    /**
     * @param laycanFirstDay the laycanFirstDay to set
     */
    public void setLaycanFirstDay(Date laycanFirstDay) {
        this.laycanFirstDay = laycanFirstDay;
    }

    /**
     * @param laycanLastDay the laycanLastDay to set
     */
    public void setLaycanLastDay(Date laycanLastDay) {
        this.laycanLastDay = laycanLastDay;
    }

    /**
     * @return the laycanFirstDay
     */
    public Date getLaycanFirstDay() {
        return laycanFirstDay;
    }

    /**
     * @return the laycanLastDay
     */
    public Date getLaycanLastDay() {
        return laycanLastDay;
    }

}