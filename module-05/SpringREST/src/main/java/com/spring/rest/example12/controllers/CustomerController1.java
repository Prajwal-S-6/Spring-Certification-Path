package com.spring.rest.example12.controllers;

import com.spring.rest.example12.ds.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/v1")
public class CustomerController1 {

    @GetMapping("/customerA")
    public Customer getCustomerA() {
        return new Customer("CC", "Caitlin", "Chen");
    }

    @GetMapping("/customerB")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer getCustomerB() {
        return new Customer("CC", "Caitlin", "Chen");
    }
}
