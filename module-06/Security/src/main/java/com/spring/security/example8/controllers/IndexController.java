package com.spring.security.example8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/home"})
    public String index() {
        return "home8";
    }

    @GetMapping("/error")
    public String error() {
        return "error8";
    }
}
