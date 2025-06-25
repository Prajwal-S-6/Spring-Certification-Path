package com.spring.rest.example5.controllers;

import com.spring.rest.example5.dao.AddressDao;
import com.spring.rest.example5.dao.CustomerDao;
import com.spring.rest.example5.ds.Address;
import com.spring.rest.example5.ds.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
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


    @PostMapping("/customers")
    public EntityModel<Customer> addCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(BAD_REQUEST);
        }
        Customer savedCustomer = customerDao.save(customer);
        return EntityModel.of(savedCustomer,
                linkTo(methodOn(RestApiController.class).getCustomer(savedCustomer.getId())).withSelfRel());
    }

    @PostMapping("/customers/{id}/addresses")
    public EntityModel<Address> addAddress(@PathVariable("id") int id, @RequestBody @Valid Address address, BindingResult bindingResult) {
        Customer customer = customerDao.findById(id).orElseThrow(ResourceNotFoundException::new);
        if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(BAD_REQUEST);
        }

        address.setCustomer(customer);
        address = addressDao.save(address);

        customer.getAddresses().add(address);
        customerDao.save(customer);

        return EntityModel.of(address,
                linkTo(methodOn(RestApiController.class).getAddress(customer.getId(), address.getId())).withSelfRel());

    }

    @PutMapping("/customers")
    public CollectionModel<EntityModel<Customer>> bulkUpdateCustomers(@RequestBody List<Customer> customerList) {
        customerDao.deleteAll();

        Iterable<Customer> savedCustomers = customerDao.saveAll(customerList);

        List<EntityModel<Customer>> customers = StreamSupport.stream(savedCustomers.spliterator(), false)
                .map(customer -> EntityModel.of(customer, linkTo(methodOn(RestApiController.class).getCustomer(customer.getId())).withSelfRel()))
                .toList();

        return CollectionModel.of(customers,
                linkTo(methodOn(RestApiController.class).listAllCustomers()).withRel("customers"));
    }

    @PutMapping("/customers/{id}/addresses")
    public CollectionModel<EntityModel<Address>> bulkUpdateAddress(@PathVariable("id") int id, @RequestBody List<Address> addressList) {
        Customer customer = customerDao.findById(id).orElseThrow(ResourceNotFoundException::new);

        List<Address> addresses = customer.getAddresses();
        addresses.forEach(address -> address.setCustomer(null));
        addressDao.deleteAll();

        addressList.forEach(address -> address.setCustomer(customer));
        Iterable<Address> savedAddress = addressDao.saveAll(addressList);

        List<EntityModel<Address>> addressModel = StreamSupport.stream(savedAddress.spliterator(), false)
                .map(address -> EntityModel.of(address, linkTo(methodOn(RestApiController.class).getAddress(customer.getId(), address.getId())).withSelfRel()))
                .toList();

        return CollectionModel.of(addressModel,
                linkTo(methodOn(RestApiController.class).getCustomer(id)).withRel("customers"));

    }

    @PutMapping("/customers/{id}")
    public EntityModel<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody @Valid Customer customer) {
        customer.setId(id);
        Customer savedCustomer = customerDao.save(customer);

        return EntityModel.of(savedCustomer,
                linkTo(methodOn(RestApiController.class).getCustomer(savedCustomer.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).listAllCustomers()).withRel("customers"));
    }

    @PutMapping("/customers/{customerId}/addresses/{addressId}")
    public EntityModel<Address> updateAddress(@PathVariable("customerId") int customerId, @PathVariable("addressId") int addressId, @RequestBody @Valid Address address) {
        Customer customer = customerDao.findById(customerId).orElseThrow(ResourceNotFoundException::new);

        address.setId(addressId);
        address.setCustomer(customer);

        Address savedAddress = addressDao.save(address);

        return EntityModel.of(savedAddress,
                linkTo(methodOn(RestApiController.class).getAddress(customerId, savedAddress.getId())).withSelfRel(),
                linkTo(methodOn(RestApiController.class).getCustomer(customerId)).withRel("customers"));
    }

}
