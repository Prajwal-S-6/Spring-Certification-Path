package com.spring.rest.example14.controllers;

import com.spring.rest.example14.ds.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller4")
public class Controller4 {

    @GetMapping("/method1")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer method1() {
        return new Customer("PS", "Praj", "S");
    }

    @GetMapping("/method2")
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public Customer method2() {
        return new Customer("PS", "Praj", "S");
    }
}
