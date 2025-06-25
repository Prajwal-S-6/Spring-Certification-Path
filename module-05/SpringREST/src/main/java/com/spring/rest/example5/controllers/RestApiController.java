package com.spring.rest.example5.controllers;

import com.spring.rest.example5.dao.AddressDao;
import com.spring.rest.example5.dao.CustomerDao;
import com.spring.rest.example5.ds.Address;
import com.spring.rest.example5.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class RestApiController {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> listAllCustomers() {
        List<EntityModel<Customer>> customers = StreamSupport.stream(customerDao.findAll().spliterator(), false)
                .map(customer -> EntityModel.of(customer, linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(customers, linkTo(methodOn(IndexController.class).index()).withSelfRel());
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomer(@PathVariable("id") int id) {
        Customer customer = customerDao.findById(id).orElseThrow(ResourceNotFoundException::new);

        return EntityModel.of(customer, linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).listAllAddresses(customer.getId())).withRel("addresses"),
                linkTo(methodOn(RestApiController.class).listAllCustomers()).withRel("customers")
        );
    }

    @GetMapping("/customers/{id}/addresses")
    public CollectionModel<EntityModel<Address>> listAllAddresses(@PathVariable("id") int id) {
        Customer customer = customerDao.findById(id).orElseThrow(ResourceNotFoundException::new);

        List<EntityModel<Address>> addresses = customer.getAddresses().stream()
                .map(address -> EntityModel.of(address,
                        linkTo(methodOn(RestApiController.class).getAddress(id, address.getId())).withSelfRel(),
                        linkTo(methodOn(RestApiController.class).getCustomer(address.getCustomer().getId())).withRel("customers")))
                .collect(Collectors.toList());

        return CollectionModel.of(addresses);
    }

    @GetMapping("/customers/{customerId}/addresses/{addressId}")
    public EntityModel<Address> getAddress(@PathVariable("customerId") int customerId, @PathVariable("addressId") int addressId) {
        Customer customer = customerDao.findById(customerId).orElseThrow(ResourceNotFoundException::new);

        Address address = customer.getAddresses().stream()
                .filter(address1 -> address1.getId().equals(addressId))
                .findAny()
                .orElseThrow(ResourceNotFoundException::new);

        return EntityModel.of(address,
                linkTo(methodOn(RestApiController.class).getAddress(customer.getId(), address.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).listAllAddresses(customerId)).withRel("addresses"),
                linkTo(methodOn(RestApiController.class).getCustomer(customerId)).withRel("customers")
                );
    }

}
