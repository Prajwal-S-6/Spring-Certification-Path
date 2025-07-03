package com.spring.security.example4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login1";
    }

    @GetMapping("/login-error")
    public ModelAndView loginError() {
        return new ModelAndView("login1", "loginError", true );
    }
}
