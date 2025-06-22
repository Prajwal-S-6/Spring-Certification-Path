package com.spring.mvc.example10.controllers;

import com.spring.mvc.example10.ds.Address;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Type09ModelAttribute {

    @GetMapping("/actionI1")
    public String actionI1(@ModelAttribute("address")Address address) {
        return "address-form10";
    }

    @PostMapping("/actionI1")
    public String actionI2(@ModelAttribute("address") @Valid Address address, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "address-form10";
        }
        return "address-display10";

    }
}
