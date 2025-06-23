package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static java.util.Arrays.asList;

@Controller
public class Type08ModelAndView {

    @GetMapping("/actionH1")
    public ModelAndView actionH1() {
        return new ModelAndView("person-display11", new BindingAwareModelMap().addAttribute("person", new Person("Praj", "S")));
    }

    @GetMapping("/actionH2")
    public ModelAndView actionH2() {
        return new ModelAndView("names-and-cities11", Map.of(
                "names", asList("John", "Mary", "William", "James"),
                "cities", asList("New York City", "Tokyo", "Sydney", "Bengaluru")
        ), HttpStatus.OK);
    }
}
