package com.spring.rest.example1.controllers;

import com.spring.rest.example1.dao.CustomerDao;
import com.spring.rest.example1.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerApiController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }
}
