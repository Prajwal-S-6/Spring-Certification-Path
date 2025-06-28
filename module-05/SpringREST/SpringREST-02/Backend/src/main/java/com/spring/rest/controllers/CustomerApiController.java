package com.spring.rest.controllers;

import com.spring.rest.dao.CustomersDao;
import com.spring.rest.ds.Customer;
import com.spring.rest.ds.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerApiController {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping("/customers")
    public ResponseEntity<Customers> customersList() {
        return ResponseEntity.ok().body(new Customers(customersDao.findAll()));
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(customersDao.save(customer));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        if(customersDao.existsById(id)) {
            customersDao.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
