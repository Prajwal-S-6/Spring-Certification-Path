package com.spring.rest.example3.controllers;

import com.spring.rest.example3.dao.AddressDao;
import com.spring.rest.example3.dao.CustomerDao;
import com.spring.rest.example3.ds.Address;
import com.spring.rest.example3.ds.Customer;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.ResponseEntity;
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
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressesDao;

    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> listCustomers() {
        List<EntityModel<Customer>> customers = StreamSupport.stream(customerDao.findAll().spliterator(), false)
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
        Customer createdCustomer = customerDao.save(customer);

        return EntityModel.of(
                createdCustomer,
                linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel()
        );
    }

    @PutMapping("/customers")
    public CollectionModel<EntityModel<Customer>> updateCustomers(@RequestBody @Valid Collection<Customer> customers) {
        customerDao.deleteAll();
        Iterable<Customer> updatedCustomers = customerDao.saveAll(customers);

        List<EntityModel<Customer>> customerResources = StreamSupport.stream(updatedCustomers.spliterator(), false)
                .map(customer -> EntityModel.of(customer, linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(
                customerResources,
                linkTo(methodOn(RestApiController.class).listCustomers()).withRel("customers")
        );
    }

    @DeleteMapping("/customers")
    public ResponseEntity deleteCustomers() {
        if (customerDao.count() > 0) {
            customerDao.deleteAll();
            return new ResponseEntity(NO_CONTENT);
        } else
            return new ResponseEntity(NOT_FOUND);
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomer(@PathVariable int id) {
        Customer customer = customerDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        return EntityModel.of(
                customer,
                linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).listAddresses(id)).withRel("addresses"),
                linkTo(methodOn(RestApiController.class).listCustomers()).withRel("customers")
        );
    }

    @PutMapping("/customers/{id}")
    public EntityModel<Customer> updateCustomer(@PathVariable int id, @RequestBody @Valid Customer customer) {

        customer.setId(id);
        Customer savedCustomer = customerDao.save(customer);

        return EntityModel.of(
                savedCustomer,
                linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).listCustomers()).withRel("customers")
        );
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        if (customerDao.existsById(id)) {
            customerDao.deleteById(id);
            return new ResponseEntity(NO_CONTENT);
        } else
            return new ResponseEntity(NOT_FOUND);
    }

    @GetMapping("/customers/{id}/addresses")
    public CollectionModel<EntityModel<Address>> listAddresses(@PathVariable int id) {
        Customer customer = customerDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        List<EntityModel<Address>> addresses = customer.getAddresses().stream()
                .map(address -> EntityModel.of(address,
                        linkTo(methodOn(RestApiController.class).getAddress(id, address.getId())).withSelfRel(),
                        linkTo(methodOn(RestApiController.class).getCustomer(address.getCustomer().getId())).withRel("customer"))
                )
                .collect(Collectors.toList());

        return CollectionModel.of(addresses);
    }

    @PostMapping("/customers/{id}/addresses")
    public EntityModel<Address> createAddress(@PathVariable int id, @RequestBody @Valid Address address) {
        Customer customer = customerDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        address.setCustomer(customer);
        address = addressesDao.save(address);

        customer.getAddresses().add(address);

        customer = customerDao.save(customer);

        return EntityModel.of(
                address,
                linkTo(methodOn(RestApiController.class).getAddress(customer.getId(), address.getId())).withSelfRel()
        );
    }

    @PutMapping("/customers/{id}/addresses")
    public CollectionModel<EntityModel<Address>> updateAddresses(@PathVariable int id, @RequestBody @Valid List<Address> addresses) {
        Customer customer = customerDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        List<Address> currentForCustomer = customer.getAddresses();
        currentForCustomer.forEach(address -> address.setCustomer(null));
        addressesDao.deleteAll(currentForCustomer);

        addresses.forEach(address -> address.setCustomer(customer));
        Iterable<Address> savedAddresses = addressesDao.saveAll(addresses);

        List<EntityModel<Address>> resources = StreamSupport.stream(savedAddresses.spliterator(), false)
                .map(address -> EntityModel.of(address, linkTo(methodOn(RestApiController.class).getAddress(id, address.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(
                resources,
                linkTo(methodOn(RestApiController.class).getCustomer(id)).withRel("customer")
        );
    }

    @DeleteMapping("/customers/{customerId}/addresses")
    public ResponseEntity deleteAddresses(@PathVariable int customerId) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        List<Address> addresses = customer.getAddresses();
        if (addresses.isEmpty())
            throw new ResponseStatusException(NOT_FOUND);

        addresses.forEach(address -> address.setCustomer(null));
        addressesDao.deleteAll(addresses);

        return new ResponseEntity(NO_CONTENT);
    }

    @GetMapping("/customers/{customerId}/addresses/{addressId}")
    public EntityModel<Address> getAddress(@PathVariable int customerId, @PathVariable int addressId) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        Address customerAddress = customer.getAddresses().stream()
                .filter(address -> address.getId().equals(addressId))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        return EntityModel.of(
                customerAddress,
                linkTo(methodOn(RestApiController.class).getAddress(customerId, customerAddress.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).listAddresses(customerId)).withRel("addresses"),
                linkTo(methodOn(RestApiController.class).getCustomer(customerId)).withRel("customer")
        );
    }

    @PutMapping("/customers/{customerId}/addresses/{addressId}")
    public EntityModel<Address> updateAddress(@PathVariable int customerId, @PathVariable int addressId, @RequestBody @Valid Address address) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        if (!addressesDao.existsById(addressId))
            throw new ResponseStatusException(NOT_FOUND);

        address.setId(addressId);
        address.setCustomer(customer);

        Address savedAddress = addressesDao.save(address);

        return EntityModel.of(
                savedAddress,
                linkTo(methodOn(RestApiController.class).getAddress(customerId, savedAddress.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).getCustomer(customerId)).withRel("customer")
        );
    }

    @DeleteMapping("/customers/{customerId}/addresses/{addressId}")
    public ResponseEntity deleteAddress(@PathVariable int customerId, @PathVariable int addressId) {
        if (!customerDao.existsById(customerId))
            throw new ResponseStatusException(NOT_FOUND);

        Address address = addressesDao.findById(addressId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        address.setCustomer(null);
        addressesDao.delete(address);

        return new ResponseEntity(NO_CONTENT);
    }
}
