package com.spring.rest.example12.controllers;

import com.spring.rest.example12.ds.Customer;
import com.spring.rest.example12.exceptions.CustomBadRequestException;
import com.spring.rest.example12.exceptions.CustomPaymentRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/v3")
public class CustomerController3 {

    @GetMapping("/customerA")
    public Customer customerA() {
        throw new CustomBadRequestException();
    }

    @GetMapping("/customerB")
    public Customer customerB() {
        throw new CustomPaymentRequiredException();
    }
}
