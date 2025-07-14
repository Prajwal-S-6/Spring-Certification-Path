package com.spring.security.example10.controllers;

import com.spring.security.example10.dto.LoginRequest;
import com.spring.security.example10.utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
            return jwtUtils.generateToken(loginRequest.username());
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('READ')")
    public String getTest() {
        return "Success";
    }

    @GetMapping("/test/{id}")
    @PreAuthorize("@myCustomSecurityComponent.isIdOne(#id)")
    public String testWithId(@PathVariable int id) {
        return "Success " +id;
    }



}
