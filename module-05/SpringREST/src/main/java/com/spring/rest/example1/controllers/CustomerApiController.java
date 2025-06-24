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

import static org.springframework.http.HttpStatus.*;

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


    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult, @PathVariable Integer id) {
        if(!bindingResult.hasErrors()) {
            if(customerDao.existsById(id)) {
                customer.setId(id);
                Customer savedCustomer = customerDao.save(customer);

                return ResponseEntity.ok(savedCustomer);
            } else {
                throw  new ResponseStatusException(NOT_FOUND, "No customer exists with id: "+id);
            }

        }
        throw  new ResponseStatusException(BAD_REQUEST, "Bad Request data");
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        if(customerDao.existsById(id)) {
            customerDao.deleteById(id);
            return ResponseEntity.status(NO_CONTENT).build();
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Customer no found with id: " + id);
        }
    }

}
