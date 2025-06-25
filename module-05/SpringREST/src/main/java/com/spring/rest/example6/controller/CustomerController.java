package com.spring.rest.example6.controller;

import com.spring.rest.example6.dao.CustomerDao;
import com.spring.rest.example6.ds.Customer;
import com.spring.rest.example6.ds.Customers;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    public CustomerDao customerDao;

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> listCustomerJSON() {
        return customerDao.findAll();
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_XML_VALUE)
    public Customers listCustomerXML() {
        return new Customers(customerDao.findAll());
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(@RequestBody @Valid Customer customer) {
        return customerDao.save(customer);
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomerXML(@RequestBody @Valid Customer customer) {
        return customerDao.save(customer);
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Customer createCustomerJSON(@RequestBody @Valid Customer customer) {
        return customerDao.save(customer);
    }

}
