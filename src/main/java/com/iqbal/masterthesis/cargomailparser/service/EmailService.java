package com.iqbal.masterthesis.cargomailparser.service;

import java.util.Optional;

import com.iqbal.masterthesis.cargomailparser.model.Email;
import com.iqbal.masterthesis.cargomailparser.repositories.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmailService
 */
@Service
public class EmailService {
    
    @Autowired
    private EmailRepository emailRepo;

    public Email findById(Integer id) {
        Optional<Email> optionalEmail = emailRepo.findById(id);
        if (!optionalEmail.isPresent()) {
            return null;
        }
        Email email = optionalEmail.get();
        return email;
    }
}