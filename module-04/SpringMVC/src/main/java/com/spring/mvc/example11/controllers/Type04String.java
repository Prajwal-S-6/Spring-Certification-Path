package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Type04String {

    @GetMapping("/actionD1")
    public String actionD1() {
        return "hello11";
    }

    @GetMapping("/actionD2")
    public String actionD2(@ModelAttribute("person")Person person) {
        return "person11";
    }

    @PostMapping("/actionD2")
    public String actionD3(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, Model model) {
        model.addAttribute("submit", true);
        return "person11";
    }
}
