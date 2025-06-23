package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Type01ResponseBody {

    @GetMapping("/actionA1")
    @ResponseBody
    public String actionA1() {
        return String.format("Returning String value as ResponseBody" );
    }

    @GetMapping("/actionA2")
    @ResponseBody
    public Person actionA2() {
        return new Person("Praj", "S");
    }
}
