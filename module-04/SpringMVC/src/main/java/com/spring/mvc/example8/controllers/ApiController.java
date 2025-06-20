package com.spring.mvc.example8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @GetMapping("{name}")
    @ResponseBody
    public String actionA(@PathVariable String name) {
        return String.format("PathVariable name: %s", name);
    }

    @GetMapping("/actionB/city/{city}")
    @ResponseBody
    public String actionB(@PathVariable(name = "city") String city) {
        return String.format("PathVariable city: %s", city);
    }
}
