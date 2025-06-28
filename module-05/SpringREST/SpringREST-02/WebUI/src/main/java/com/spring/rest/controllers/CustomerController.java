package com.spring.rest.controllers;

import com.spring.rest.ds.Customer;
import com.spring.rest.ds.Customers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class CustomerController {

    @Value("${app.backend.uri}")
    private String backendURI;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/customers")
    public ModelAndView getCustomers() {
        ResponseEntity<Customers> customersResponseEntity = restTemplate.getForEntity(backendURI + "/customers", Customers.class);

        if(customersResponseEntity.getStatusCode() == HttpStatus.OK) {
            return new ModelAndView("customers", "customers", Objects.requireNonNull(customersResponseEntity.getBody()).getCustomers());
        }

        else {
            throw new IllegalStateException(String.format("Unable to get of list customers, Http status %s", customersResponseEntity.getStatusCode()));
        }
    }

    @GetMapping("/customers/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-create";
    }

    @PostMapping("/customers/create")
    public String createCustomerNew(@ModelAttribute("customerForm") Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "customer-create";
        } else {
            ResponseEntity<Customer> responseEntity = restTemplate.postForEntity(backendURI+"/customers",customer, Customer.class);

            if(responseEntity.getStatusCode() != HttpStatus.OK) {
                throw new IllegalStateException("Unable to create customer");
            }

            return "redirect:/customers";
        }
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        restTemplate.delete(backendURI+"/customers/{id}", id);

        return "redirect:/customers";
    }
}
