package com.iqbal.masterthesis.cargomailparser.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Optional;

import com.iqbal.masterthesis.cargomailparser.model.Cargo;
import com.iqbal.masterthesis.cargomailparser.model.Email;
import com.iqbal.masterthesis.cargomailparser.model.Evaluation;
import com.iqbal.masterthesis.cargomailparser.repositories.EmailRepository;
import com.iqbal.masterthesis.cargomailparser.repositories.EvaluationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * EvaluateController
 */
@Controller
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    EvaluationRepository evaluationRepo;

    @Autowired
    EmailRepository emailRepo;

    @GetMapping(value = "evaluation/{emailId}")
    public String index(@PathVariable Integer emailId, Model model) throws IOException, ClassNotFoundException {
        Optional<Email> optionalEmail = emailRepo.findById(emailId);
        if (!optionalEmail.isPresent()) {
            return "Email not found!";
        }
        Email email = optionalEmail.get();
        if (evaluationRepo.findByEmail(email) != null) {
            return "Email is already evaluated!";
        }
        Cargo cargo = email.getCargo().get(0);
        Evaluation evaluation = new Evaluation(email);
        evaluation = evaluationRepo.save(evaluation);
        model.addAttribute("cargo", cargo);
        model.addAttribute("email", email);
        model.addAttribute("evaluation", evaluation);

        return "classpath:templates/evaluationPage";
    }

    @PostMapping(value = "save")
    public String name(@ModelAttribute Evaluation evaluation, BindingResult bindingResult) { 
        int truePositive = 0;
        int falsePositive = 0;
        float precisions = 0;
        float recall = 0;
        if((evaluation.isDescription() != null) && (evaluation.isDescription() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isDescription() != null && evaluation.isDescription() == false){
            falsePositive+=1;
        }
        if((evaluation.isQuantity() != null) && (evaluation.isQuantity() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isQuantity() != null && evaluation.isQuantity() == false){
            falsePositive+=1;
        }
        if((evaluation.isCommision() != null) && (evaluation.isCommision() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isCommision() != null && evaluation.isCommision() == false){
            falsePositive+=1;
        }
        if((evaluation.isLoading_port() != null) && (evaluation.isLoading_port() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isLoading_port() != null && evaluation.isLoading_port() == false){
            falsePositive+=1;
        }
        if((evaluation.isDischarging_port() != null) && (evaluation.isDischarging_port() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isDischarging_port() != null && evaluation.isDischarging_port() == false){
            falsePositive+=1;
        }
        if((evaluation.isLaycan_first() != null) && (evaluation.isLaycan_first() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isLaycan_first() != null && evaluation.isLaycan_first() == false){
            falsePositive+=1;
        }
        if((evaluation.isLaycan_last() != null) && (evaluation.isLaycan_last() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isLaycan_last() != null && evaluation.isLaycan_last() == false){
            falsePositive+=1;
        }
        if((evaluation.isLoading_rate() != null) && (evaluation.isLoading_rate() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isLoading_rate() != null && evaluation.isLoading_rate() == false){
            falsePositive+=1;
        }
        if((evaluation.isDischarging_rate() != null) && (evaluation.isDischarging_rate() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isDischarging_rate() != null && evaluation.isDischarging_rate() == false){
            falsePositive+=1;
        }
        if((evaluation.isLoading_rate_type() != null) && (evaluation.isLoading_rate_type() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isLoading_rate_type() != null && evaluation.isLoading_rate_type() == false){
            falsePositive+=1;
        }
        if((evaluation.isDischarging_rate_type() != null) && (evaluation.isDischarging_rate_type() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isDischarging_rate_type() != null && evaluation.isDischarging_rate_type() == false){
            falsePositive+=1;
        }
        if((evaluation.isStowage_factor() != null) && (evaluation.isStowage_factor() == true)){ 
            truePositive+=1; 
        }else if(evaluation.isStowage_factor() != null && evaluation.isStowage_factor() == false){
            falsePositive+=1;
        }
        precisions = truePositive/(falsePositive + truePositive); 
        recall     = falsePositive/12;//total attributes
        evaluation.setPrecisions(precisions);
        evaluation.setRecall(recall);
        evaluationRepo.save(evaluation);
       
        return "redirect:/evaluate/list";
    }

    @GetMapping(value = "list")
    public String getMethodName(Model model) {
        model.addAttribute("evaluations", evaluationRepo.findAll());
        return "classpath:templates/evaluationList";
    }

    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        Optional<Evaluation> optionalEvaluation = evaluationRepo.findById(id);
        if (!optionalEvaluation.isPresent()) {
            return "Not found!";
        }
        Evaluation evaluation = optionalEvaluation.get();
        evaluationRepo.delete(evaluation);
        return "classpath:templates/evaluationList";
    }
}