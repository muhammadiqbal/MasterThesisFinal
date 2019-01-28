package com.iqbal.masterthesis.cargomailparser.repositories;

import com.iqbal.masterthesis.cargomailparser.model.Email;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmailRepository
 */
public interface EmailRepository extends JpaRepository<Email, Long>{

    
}