package com.spring.mvc.example2.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc")
public class AddNumbersController {

    @GetMapping("/add-numbers")
    public String addNumbers(@RequestParam("numberA") int numberA, @RequestParam("numberB") int numberB, Model model) {
        model.addAttribute("numberA", numberA);
        model.addAttribute("numberB", numberB);
        model.addAttribute("result", numberA+numberB);
        return "add-numbers";
    }
}
