package com.spring.security.example10.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return "jwt token";
    }
}
