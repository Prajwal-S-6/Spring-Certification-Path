package com.spring.rest.example14.controllers;

import com.spring.rest.example14.ds.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller1 {

    @GetMapping("/method1")
    @ResponseBody
    public Customer method1() {
        return new Customer("PS", "Praj", "S");
    }

    @GetMapping("/method2")
    public String method2(Model model) {
        model.addAttribute("customer", new Customer("PS", "Praj", "S"));
        return "customer14";
    }
}
