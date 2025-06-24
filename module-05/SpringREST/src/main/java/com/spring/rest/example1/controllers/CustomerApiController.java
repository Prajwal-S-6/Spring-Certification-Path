package com.spring.rest.example1.controllers;

import com.spring.rest.example1.dao.CustomerDao;
import com.spring.rest.example1.ds.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class CustomerApiController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id) {
        return customerDao.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Customer savedCustomer = customerDao.save(customer);
        return ResponseEntity.created(URI.create("/customers" + savedCustomer.getId())).body(savedCustomer);
    }


}
