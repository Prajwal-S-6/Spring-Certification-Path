package com.spring.rest.controllers;

import com.spring.rest.ds.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customers")
    public Customer getCustomer() {
        return new Customer("PS", "Praj", "S");
    }
}
