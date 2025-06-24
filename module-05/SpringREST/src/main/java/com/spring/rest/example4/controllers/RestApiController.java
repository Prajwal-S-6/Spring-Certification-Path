package com.spring.rest.example4.controllers;

import com.spring.rest.example4.dao.CustomerDao;
import com.spring.rest.example4.ds.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
public class RestApiController {

    @Autowired
    private CustomerDao customersDao;

    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> listAllCustomers() {
        List<EntityModel<Customer>> customers = StreamSupport.stream(customersDao.findAll().spliterator(), false)
                .map(customer -> EntityModel.of(
                        customer,
                        linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel()
                ))
                .collect(Collectors.toList());

        return CollectionModel.of(
                customers,
                linkTo(methodOn(IndexController.class).index()).withRel("index")
        );
    }

    @PostMapping("/customers")
    public EntityModel<Customer> createCustomer(@RequestBody @Valid Customer customer) {
        Customer createdCustomer = customersDao.save(customer);

        return EntityModel.of(
                createdCustomer,
                linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel()
        );
    }

    @PutMapping("/customers")
    public CollectionModel<EntityModel<Customer>> updateCustomers(@RequestBody @Valid Collection<Customer> customers) {
        customersDao.deleteAll();
        Iterable<Customer> updatedCustomers = customersDao.saveAll(customers);

        List<EntityModel<Customer>> customerResources = StreamSupport.stream(updatedCustomers.spliterator(), false)
                .map(customer -> EntityModel.of(customer, linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(
                customerResources,
                linkTo(methodOn(RestApiController.class).listAllCustomers()).withRel("customers")
        );
    }

    @DeleteMapping("/customers")
    public ResponseEntity deleteCustomers() {
        if (customersDao.count() > 0) {
            customersDao.deleteAll();
            return new ResponseEntity(NO_CONTENT);
        } else
            return new ResponseEntity(NOT_FOUND);
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomer(@PathVariable int id) {
        Customer customer = customersDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        return EntityModel.of(
                customer,
                linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).listAllCustomers()).withRel("customers")
        );
    }

    @PutMapping("/customers/{id}")
    public EntityModel<Customer> updateCustomer(@PathVariable int id, @RequestBody @Valid Customer customer) {

        customer.setId(id);
        Customer savedCustomer = customersDao.save(customer);

        return EntityModel.of(
                savedCustomer,
                linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).listAllCustomers()).withRel("customers")
        );
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        if (customersDao.existsById(id)) {
            customersDao.deleteById(id);
            return new ResponseEntity(NO_CONTENT);
        } else
            return new ResponseEntity(NOT_FOUND);
    }
}
