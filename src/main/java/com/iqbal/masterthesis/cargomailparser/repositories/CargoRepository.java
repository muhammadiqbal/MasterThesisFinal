package com.iqbal.masterthesis.cargomailparser.repositories;

import com.iqbal.masterthesis.cargomailparser.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CargoRepository
 */
public interface CargoRepository extends JpaRepository<Cargo, Long>{
    
}