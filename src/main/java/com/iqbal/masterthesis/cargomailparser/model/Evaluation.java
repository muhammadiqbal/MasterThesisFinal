package com.iqbal.masterthesis.cargomailparser.model;

import java.time.LocalDateTime;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Evaluation
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "email_id") })
public class Evaluation implements Serializable{

    /**
     * @return the parsing time in miliseconds  
     */    
    public Long getParsingTime(){
        return this.email.getParsingTimeMiliSecond();
    }

    /**
     * @param precisions the precisions to set
     */
    public void setPrecisions(float precisions) {
        this.precisions = precisions;
    }

    /**
     * @return the recall
     */
    public float getRecall() {
        return recall;
    }

    /**
     * @param recall the recall to set
     */
    public void setRecall(float recall) {
        this.recall = recall;
    }

    /**
     * @return the stowage_factor
     */
    public Boolean isStowage_factor() {
        return stowage_factor;
    }

    /**
     * @param stowage_factor the stowage_factor to set
     */
    public void setStowage_factor(Boolean stowage_factor) {
        this.stowage_factor = stowage_factor;
    }

    /**
     * @return the discharging_rate_type
     */
    public Boolean isDischarging_rate_type() {
        return discharging_rate_type;
    }

    /**
     * @param discharging_rate_type the discharging_rate_type to set
     */
    public void setDischarging_rate_type(Boolean discharging_rate_type) {
        this.discharging_rate_type = discharging_rate_type;
    }

    /**
     * @return the loading_rate_type
     */
    public Boolean isLoading_rate_type() {
        return loading_rate_type;
    }

    /**
     * @param loading_rate_type the loading_rate_type to set
     */
    public void setLoading_rate_type(Boolean loading_rate_type) {
        this.loading_rate_type = loading_rate_type;
    }

    /**
     * @return the discharging_rate
     */
    public Boolean isDischarging_rate() {
        return discharging_rate;
    }

    /**
     * @param discharging_rate the discharging_rate to set
     */
    public void setDischarging_rate(Boolean discharging_rate) {
        this.discharging_rate = discharging_rate;
    }

    /**
     * @return the loading_rate
     */
    public Boolean isLoading_rate() {
        return loading_rate;
    }

    /**
     * @param loading_rate the loading_rate to set
     */
    public void setLoading_rate(Boolean loading_rate) {
        this.loading_rate = loading_rate;
    }

    /**
     * @return the laycan_last
     */
    public Boolean isLaycan_last() {
        return laycan_last;
    }

    /**
     * @param laycan_last the laycan_last to set
     */
    public void setLaycan_last(Boolean laycan_last) {
        this.laycan_last = laycan_last;
    }

    /**
     * @return the laycan_first
     */
    public Boolean isLaycan_first() {
        return laycan_first;
    }

    /**
     * @param laycan_first the laycan_first to set
     */
    public void setLaycan_first(Boolean laycan_first) {
        this.laycan_first = laycan_first;
    }

    /**
     * @return the discharging_port
     */
    public Boolean isDischarging_port() {
        return discharging_port;
    }

    /**
     * @param discharging_port the discharging_port to set
     */
    public void setDischarging_port(Boolean discharging_port) {
        this.discharging_port = discharging_port;
    }

    /**
     * @return the loading_port
     */
    public Boolean isLoading_port() {
        return loading_port;
    }

    /**
     * @param loading_port the loading_port to set
     */
    public void setLoading_port(Boolean loading_port) {
        this.loading_port = loading_port;
    }

    /**
     * @return the commision
     */
    public Boolean isCommision() {
        return commision;
    }

    /**
     * @param commision the commision to set
     */
    public void setCommision(Boolean commision) {
        this.commision = commision;
    }

    /**
     * @return the quantity
     */
    public Boolean isQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Boolean quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the description
     */
    public Boolean isDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(Boolean description) {
        this.description = description;
    }

    /**
     * @return the email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    public int getEmailId() {
        return this.email.getId();
    }

    public Evaluation() {
    }

    public Evaluation(Email email) {
        this.email = email;
    }

    /**
     * @return the precisions
     */
    public float getPrecisions() {
        return precisions;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the createDateTime
     */
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email_id")
    private Email email;

    @Nullable
    Boolean description;
    
    @Nullable
    Boolean quantity;
    
    @Nullable
    Boolean commision;
    
    @Nullable
    Boolean loading_port;
    
    @Nullable
    Boolean discharging_port;
    
    @Nullable
    Boolean laycan_first;
    
    @Nullable
    Boolean laycan_last;
    
    @Nullable
    Boolean loading_rate;
    
    @Nullable
    Boolean discharging_rate;
    
    @Nullable
    Boolean loading_rate_type;
    
    @Nullable
    Boolean discharging_rate_type;
    
    @Nullable
    Boolean stowage_factor;

    private float recall;
    private float precisions;

    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

}