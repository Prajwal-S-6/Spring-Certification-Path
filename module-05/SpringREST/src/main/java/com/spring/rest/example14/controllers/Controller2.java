package com.spring.rest.example14.controllers;

import com.spring.rest.example14.ds.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller2")
public class Controller2 {

    @GetMapping("method1")
    public Customer method1() {
        return new Customer("PS", "Praj", "S");
    }
}
