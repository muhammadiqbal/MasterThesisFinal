package com.iqbal.masterthesis.cargomailparser.controller;

import java.util.List;
import java.util.Optional;

import com.iqbal.masterthesis.cargomailparser.model.Cargo;
import com.iqbal.masterthesis.cargomailparser.repositories.CargoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CargoController
 */
@Controller
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    CargoRepository cargoRepo;

    @GetMapping(value="list")
    public String getMethodName(Model model) {
        List<Cargo> cargoList =  cargoRepo.findAll();
        int cargoNumber = cargoList.size();
        model.addAttribute("cargos", cargoList);
        model.addAttribute("cargoNumber", cargoNumber);
        return "classpath:templates/cargoList";
    }

    @GetMapping(value="cargo/{id}")
    public String getMethodName(@PathVariable("id") Integer id, Model model) {
        
        Optional<Cargo> optionalCargo = cargoRepo.findById(id);
        if (!optionalCargo.isPresent()) {
            return "Not found!";
        }
        Cargo cargo = optionalCargo.get(); 
        model.addAttribute("cargo", cargo);
        return "classpath:templates/cargo";
    }
    
    @PostMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        Optional<Cargo> optionalCargo = cargoRepo.findById(id);
        if (!optionalCargo.isPresent()) {
            return "Not found!";
        }
        Cargo cargo = optionalCargo.get();
        cargoRepo.delete(cargo);
        return "redirect:/cargo/list";
    }
}