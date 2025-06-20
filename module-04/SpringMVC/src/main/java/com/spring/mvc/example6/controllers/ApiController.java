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

    @RequestMapping(value = "/actionC", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String actionC() {
        return "Handled with @RequestMapping for GET AND POST";
    }

    @RequestMapping(path = "/actionD")
    @ResponseBody
    public String actionD() {
        return "Handled with @RequestMapping for all Http methods";
    }

}
