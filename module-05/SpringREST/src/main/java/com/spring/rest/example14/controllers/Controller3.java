package com.spring.rest.example14.controllers;

import com.spring.rest.example11.controllers.CustomerApiController;
import com.spring.rest.example11.ds.CustomerCriteria;
import com.spring.rest.example14.dao.CustomersDao;
import com.spring.rest.example14.ds.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class Controller3 {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> listCustomers() {
        List<EntityModel<Customer>> customers = StreamSupport.stream(customersDao.findAll().spliterator(), false)
                .map(customer -> EntityModel.of(customer, linkTo(methodOn(Controller3.class).getCustomer(customer.getId())).withSelfRel()))
                .toList();

        return CollectionModel.of(customers,
                linkTo(methodOn(Controller3.class).listCustomers()).withRel("customers"));
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomer(@PathVariable int id) {
        Customer customer = customersDao.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        return EntityModel.of(customer, linkTo(methodOn(Controller3.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(Controller3.class).listCustomers()).withRel("customers"));
    }

    @PostMapping("/customers/search")
    public ResponseEntity<List<Customer>> searchCustomerByCriteria(@RequestBody CustomerCriteria customerCriteria) {
        List<Customer> customer = customersDao.findByFirstNameLike(customerCriteria.getFirstNameLike());
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customers/count")
    public ResponseEntity customersCount() {
        return ResponseEntity.noContent().header("Customers-Count", String.valueOf(customersDao.count())).build();
    }

    @PutMapping("customers/{id}")
    public ResponseEntity<EntityModel<Customer>> updateCustomer(@PathVariable int id, @RequestBody @Valid Customer customer) {
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(CustomerApiController.class).getCustomer(id));
        ResponseEntity.BodyBuilder bodyBuilder;
        if(customersDao.existsById(id)) {
            bodyBuilder = ResponseEntity.ok();
        }
        else {
            bodyBuilder = ResponseEntity.created(linkBuilder.toUri());
        }

        customer.setId(id);
        Customer savedCustomer = customersDao.save(customer);

        return bodyBuilder.body(EntityModel.of(savedCustomer,
                linkBuilder.withSelfRel(),
                linkTo(methodOn(CustomerApiController.class).listAllCustomers()).withRel("customers")));

    }

    @PutMapping("/customers")
    public ResponseEntity bulkUpdateCustomers(@RequestBody Collection<Customer> customerCollection) {
        customersDao.deleteAll();

        customersDao.saveAll(customerCollection);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        Customer customer = customersDao.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        customersDao.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
