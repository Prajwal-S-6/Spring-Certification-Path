package com.spring.security.example4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/home"})
    public String index() {
        return "home1";
    }

    @GetMapping("/error")
    public String error() {
        return "error1";
    }
}
