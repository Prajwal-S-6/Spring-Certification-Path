package com.spring.mvc.example7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @GetMapping("/actionA")
    @ResponseBody
    public String actionA(@RequestParam("name") String name) {
        return String.format("RequestParam name: %s", name);
    }

    @GetMapping("/actionB")
    @ResponseBody
    public String actionB(@RequestParam("name") String name, @RequestParam(name = "city", required = false) String city) {
        return String.format("RequestParam name: %s; city: %s", name, city);
    }
}
