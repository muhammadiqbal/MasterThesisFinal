package com.iqbal.masterthesis.cargomailparser.repositories;

import com.iqbal.masterthesis.cargomailparser.model.Email;
import com.iqbal.masterthesis.cargomailparser.model.Evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EvaluationRepository
 */
@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer>{
    
    Evaluation findByEmail(Email email);
    
}