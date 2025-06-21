package com.spring.mvc.example9.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Type6Principal {

    @GetMapping("/actionF")
    public String actionF(Principal principal) {
        return String.format("Retrived currently authenticated user from Principal: User: %s", principal != null ? principal.getName() : "");
    }
}
