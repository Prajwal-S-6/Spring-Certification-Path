package com.spring.rest.example11.controllers;

import com.spring.rest.example11.dao.CustomersDao;
import com.spring.rest.example11.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.*;

@RestController
public class CustomerApiController {

    @Autowired
    public CustomersDao customersDao;

    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> listAllCustomers() {
        List<EntityModel<Customer>> customerList = StreamSupport.stream(customersDao.findAll().spliterator(), false)
                .map(customer -> EntityModel.of(customer, linkTo(methodOn(CustomerApiController.class).getCustomer(customer.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(customerList,
                linkTo(methodOn(CustomerApiController.class).listAllCustomers()).withSelfRel(),
                linkTo(methodOn(IndexController.class).index()).withRel("index"));
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomer(@PathVariable int id) {
        Customer customer = customersDao.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        return EntityModel.of(customer,
                linkTo(methodOn(CustomerApiController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerApiController.class).listAllCustomers()).withRel("customers"));
    }


}
