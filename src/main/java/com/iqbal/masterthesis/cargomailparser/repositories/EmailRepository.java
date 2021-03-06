package com.iqbal.masterthesis.cargomailparser.repositories;

import com.iqbal.masterthesis.cargomailparser.model.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmailRepository
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{

    
}