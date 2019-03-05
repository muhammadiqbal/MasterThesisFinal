package com.iqbal.masterthesis.cargomailparser.controller;

import java.util.Optional;

import com.iqbal.masterthesis.cargomailparser.model.Email;
import com.iqbal.masterthesis.cargomailparser.repositories.EmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * EmailController
 */
@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    EmailRepository emailRepo;

    @GetMapping(value="list")
    public String getMethodName(Model model) {
        model.addAttribute("emails", emailRepo.findAll());
        return "classpath:templates/emailList";
    }

    @GetMapping(value="email/{id}")
    public String getMethodName(@PathVariable("id") Integer id, Model model) {
        Optional<Email> optionalEmail = emailRepo.findById(id);
        if(!optionalEmail.isPresent()){
            return "Not found!";
        }
        Email email = optionalEmail.get();
        model.addAttribute("email", email);
        return "classpath:templates/email";
    }

    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        Optional<Email> optionalEmail = emailRepo.findById(id);
        if (!optionalEmail.isPresent()) {
            return "Not found!";
        }
        Email email = optionalEmail.get();
        emailRepo.delete(email);
        return "classpath:templates/EmailList";
    }
}