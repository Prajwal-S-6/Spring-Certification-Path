package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class Type07ModelAttribute {

    @GetMapping("/example11actionG1")
    @ModelAttribute("person")
    public Person actionG1() {
        return new Person("Praj", "S");
    }
}
