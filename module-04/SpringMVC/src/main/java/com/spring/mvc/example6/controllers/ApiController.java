package com.spring.mvc.example6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

    @GetMapping("/actionA")
    @ResponseBody
    public String actionA() {
        return "Handled with @GetMapping";
    }

    @RequestMapping(value = "/actionB", method = RequestMethod.GET)
    @ResponseBody
    public String actionB() {
        return "Handled with @RequestMapping";
    }


}
