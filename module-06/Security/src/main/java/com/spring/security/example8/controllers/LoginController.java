package com.spring.security.example8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login8";
    }

    @GetMapping("/login-error")
    public ModelAndView loginError() {
        return new ModelAndView("login8", "loginError", true );
    }
}
