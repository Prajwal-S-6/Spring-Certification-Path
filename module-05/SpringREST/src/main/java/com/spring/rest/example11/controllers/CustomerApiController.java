package com.spring.rest.example11.controllers;

import com.spring.rest.example11.dao.CustomersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerApiController {

    @Autowired
    public CustomersDao customersDao;
}
