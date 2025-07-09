package com.spring.security.example10.controllers;

import com.spring.security.example10.dto.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest) {
        return "jwt token";
    }
}
