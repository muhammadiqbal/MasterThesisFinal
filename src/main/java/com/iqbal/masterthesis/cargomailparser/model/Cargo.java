package com.iqbal.masterthesis.cargomailparser.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.iqbal.masterthesis.cargomailparser.languagemodel.*;
import java.io.Serializable;

@Entity
@Table
//@JsonIgnoreProperties(value = { "intValue" })
public class Cargo extends BaseModel implements Serializable{
    
    public Cargo(){
        this.modelType = "Cargo";
    }

    public Cargo(Commision commision, Quantity quantity, LDRate ldRate, PortDestination port, LaycanDate laycanDate) {
        this.modelType = "Cargo";
        this.commision = commision.getNominal();
        this.quantity = quantity.getNominal();
        this.laycan_first = laycanDate.getLaycanFirstDay();
        this.laycan_last = laycanDate.getLaycanLastDay();
        this.loading_port = port.getPortFrom();
        this.discharging_port = port.getPortTo();
        this.loading_rate = ldRate.getLoadingRate();
        this.discharging_rate = ldRate.getDischargingRate();
        this.loading_rate_type = ldRate.getLoadingRateType();
        this.discharging_rate_type = ldRate.getDischargingRateType();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;
    private float quantity;
    private float commision;
    private String loading_port;
    private String discharging_port;
    private Date laycan_first;
    private Date laycan_last;
    private float loading_rate;
    private float discharging_rate;
    private String loading_rate_type;
    private String discharging_rate_type;
    private float stowage_factor;
    private Long parsingTime;

    // @Nullable
    // @OneToOne(fetch = FetchType.EAGER)
    // private Evaluation evaluation;

    /**
     * @return the parsingTime
     */
    public Long getParsingTime() {
        return parsingTime;
    }

    /**
     * @param parsingTime the parsingTime to set
     */
    public void setParsingTime(Long parsingTime) {
        this.parsingTime = parsingTime;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return the commision
     */
    public float getCommision() {
        return commision;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the discharging_port
     */
    public String getDischarging_port() {
        return discharging_port;
    }

    /**
     * @return the discharging_rate
     */
    public float getDischarging_rate() {
        return discharging_rate;
    }

    /**
     * @return the discharging_rate_type
     */
    public String getDischarging_rate_type() {
        return discharging_rate_type;
    }

    /**
     * @return the laycan_first
     */
    public Date getLaycan_first() {
        return laycan_first;
    }

    /**
     * @return the laycan_last
     */
    public Date getLaycan_last() {
        return laycan_last;
    }

    /**
     * @return the loading_port
     */
    public String getLoading_port() {
        return loading_port;
    }

    /**
     * @return the loading_rate
     */
    public float getLoading_rate() {
        return loading_rate;
    }

    /**
     * @return the loading_rate_type
     */
    public String getLoading_rate_type() {
        return loading_rate_type;
    }

    /**
     * @return the quantity
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * @param commision the commision to set
     */
    public void setCommision(float commision) {
        this.commision = commision;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param string the discharging_port to set
     */
    public void setDischarging_port(String string) {
        this.discharging_port = string;
    }

    /**
     * @param discharging_rate the discharging_rate to set
     */
    public void setDischarging_rate(float discharging_rate) {
        this.discharging_rate = discharging_rate;
    }

    /**
     * @param discharging_rate_type the discharging_rate_type to set
     */
    public void setDischarging_rate_type(String discharging_rate_type) {
        this.discharging_rate_type = discharging_rate_type;
    }

    /**
     * @param laycan_first the laycan_first to set
     */
    public void setLaycan_first(Date laycan_first) {
        this.laycan_first = laycan_first;
    }

    /**
     * @param laycan_last the laycan_last to set
     */
    public void setLaycan_last(Date laycan_last) {
        this.laycan_last = laycan_last;
    }

    /**
     * @param loading_port the loading_port to set
     */
    public void setLoading_port(String loading_port) {
        this.loading_port = loading_port;
    }

    /**
     * @param loading_rate the loading_rate to set
     */
    public void setLoading_rate(float loading_rate) {
        this.loading_rate = loading_rate;
    }
    
    /**
     * @param loading_rate_type the loading_rate_type to set
     */
    public void setLoading_rate_type(String loading_rate_type) {
        this.loading_rate_type = loading_rate_type;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

	public void setLaycanDate(LaycanDate laycanDate) {
        this.laycan_first = laycanDate.getLaycanFirstDay();
        this.laycan_last = laycanDate.getLaycanLastDay();
	}

	public void setPortDestination(PortDestination portDestination) {
        this.loading_port = portDestination.getPortFrom();
        this.loading_port = portDestination.getPortTo();
    }

	public void setLDRate(LDRate ldRate) {
        this.loading_rate = ldRate.getLoadingRate();
        this.loading_rate_type = ldRate.getLoadingRateType();
        this.discharging_rate = ldRate.getDischargingRate();
        this.discharging_rate_type = ldRate.getDischargingRateType();
	}

    /**
     * @return the stowage_factor
     */
    public float getStowage_factor() {
        return stowage_factor;
    }

    /**
     * @param stowage_factor the stowage_factor to set
     */
    public void setStowage_factor(float stowage_factor) {
        this.stowage_factor = stowage_factor;
    }

}