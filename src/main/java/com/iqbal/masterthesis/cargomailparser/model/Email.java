package com.iqbal.masterthesis.cargomailparser.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Email
 */
@Entity
public class Email extends BaseModel {
    @Id
    private int id;
    private String subject;
    private String body;
    private String sender;
    private Date date;

    @OneToMany(fetch= FetchType.LAZY)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private List<Cargo> cargo;
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

    /**
     * @return the cargo
     */
    public List<Cargo> getCargo() {
        return cargo;
    }
}