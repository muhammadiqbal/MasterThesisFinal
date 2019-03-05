package com.iqbal.masterthesis.cargomailparser.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Email
 */
@Entity
public class Email extends BaseModel implements Serializable {

    public Email() {
    }

    public Email(Cargo cargo) {
        List<Cargo> cargoList = new ArrayList<Cargo>();
        cargoList.add(cargo);
        this.setCargo(cargoList);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Nullable
    private String subject;

    private String body;

    @Nullable
    private String sender;

    @Nullable
    private Date date;

    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

    private Long parsingTimeMiliSecond;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Cargo> cargo;

    @Nullable
    @OneToOne(fetch = FetchType.EAGER)
    private Evaluation evaluation;


    /**
     * @return the evaluation
     */
    public Evaluation getEvaluation() {
        return evaluation;
    }

    /**
     * @param evaluation the evaluation to set
     */
    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    /**
     * @return the parsingTimeMiliSecond
     */
    public Long getParsingTimeMiliSecond() {
        return parsingTimeMiliSecond;
    }

    /**
     * @param parsingTimeMiliSecond the parsingTimeMiliSecond to set
     */
    public void setParsingTimeMiliSecond(Long parsingTimeMiliSecond) {
        this.parsingTimeMiliSecond = parsingTimeMiliSecond;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }

    public void addCargo(Cargo cargo) {
        this.cargo.add(cargo);
    }

    /**
     * @return the cargo
     */
    public List<Cargo> getCargo() {
        return cargo;
    }

    /**
     * @return the createDateTime
     */
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }
}