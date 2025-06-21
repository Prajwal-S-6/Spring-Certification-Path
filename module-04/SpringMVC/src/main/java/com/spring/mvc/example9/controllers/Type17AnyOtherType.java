package com.spring.mvc.example9.controllers;

import com.spring.mvc.example9.ds.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Type17AnyOtherType {

    @GetMapping("/actionQ")
    @ResponseBody
    // will implicitly add @RequestParam("firstName"), @RequestParam("lastName")
    public String actionQ(String firstName, String lastName) {
        return String.format("Retrieved as query param as it is simple type firstName: %s, lastName: %s", firstName, lastName);
    }

    @GetMapping("/actionQ1")
    // will implicitly add @ModelAttribute("person")
    public String actionQ1(Person person) {
        return "person-form-simple";
    }

    @PostMapping("/actionQ1")
    // will implicitly add @ModelAttribute("person")
    public String submitPerson(Person person) {
        return "person-display-simple";
    }
}
