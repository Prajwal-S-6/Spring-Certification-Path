package com.spring.mvc.example9.controllers;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Type7HttpMethod {

    @RequestMapping("/actionG")
    public String actionG(HttpMethod httpMethod) {
        return String.format("Retrieved from HttpMethod %s", httpMethod.toString());
    }
}
