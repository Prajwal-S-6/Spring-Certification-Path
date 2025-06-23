package com.spring.mvc.example11.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

import static java.util.Arrays.asList;

@Controller
public class Type06ModelAndMap {

    @GetMapping("/example11actionF1")
    public Model actionF1() {
        Model model = new BindingAwareModelMap();
        model.addAttribute("names", asList("John", "Mary", "William", "James"));
        model.addAttribute("cities", asList("New York City", "Tokyo", "Sydney", "Bengaluru"));

        return model;
    }

    @GetMapping("/example11actionF2")
    public Map actionF2() {
        return Map.of("names", asList("John", "Mary", "William", "James"), "cities", asList("New York City", "Tokyo", "Sydney", "Bengaluru"));

    }
}
