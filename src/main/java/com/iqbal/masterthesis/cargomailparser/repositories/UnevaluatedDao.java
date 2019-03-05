package com.iqbal.masterthesis.cargomailparser.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.iqbal.masterthesis.cargomailparser.model.Email;


/**
 * UnevaluatedDao
 */
@Transactional
public final class UnevaluatedDao {
    @PersistenceContext
    private EntityManager em;

    public Email getUnevaluated() {
        Email email = (Email) em.createNativeQuery("SELECT e FROM Email e LEFT JOIN Evaluation ev ON e.id = ev.email_id LIMIT 1"
                                ,Email.class).getSingleResult();
        if (email == null) {
            return null;
        }  
        return email;
    }


}