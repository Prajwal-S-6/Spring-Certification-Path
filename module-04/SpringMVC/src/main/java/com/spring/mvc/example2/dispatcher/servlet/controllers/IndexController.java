package com.spring.mvc.example2.dispatcher.servlet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class IndexController {

    @GetMapping
    public String getIndex() {
        return "index";
    }

}
