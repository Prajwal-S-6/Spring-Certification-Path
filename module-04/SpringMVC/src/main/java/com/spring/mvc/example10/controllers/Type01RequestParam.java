package com.spring.mvc.example10.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Type01RequestParam {

    @GetMapping("/actionA1")
    public String actionA1(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return String.format("RequestParam - firstName: %s, lastName: %s", firstName, lastName);
    }


    /// for simple types method argument will be treated as @RequestParam by default
    @GetMapping("/actionA2")
    public String actionA2(String firstName, String lastName) {
        return String.format("RequestParam - firstName: %s, lastName: %s", firstName, lastName);
    }

    @GetMapping("/actionA3")
    public String actionA3(@RequestParam("firstName") String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        return String.format("RequestParam - firstName: %s, lastName: %s", firstName, lastName);
    }

    @GetMapping("/actionA4")
    public String actionA4(@RequestParam("firstName") String firstName, @RequestParam(value = "lastName", defaultValue = "N/A") String lastName) {
        return String.format("RequestParam - firstName: %s, lastName: %s", firstName, lastName);
    }

    @GetMapping("/actionA5")
    public String actionA5(@RequestParam("firstName") String firstName, @RequestParam(value = "lastName") Optional<String> lastName) {
        return String.format("RequestParam - firstName: %s, lastName: %s", firstName, lastName.orElse("N/A"));
    }


}
