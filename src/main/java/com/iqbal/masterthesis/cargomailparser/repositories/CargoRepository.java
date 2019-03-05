package com.iqbal.masterthesis.cargomailparser.repositories;

import com.iqbal.masterthesis.cargomailparser.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CargoRepository
 */
@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{
    
}