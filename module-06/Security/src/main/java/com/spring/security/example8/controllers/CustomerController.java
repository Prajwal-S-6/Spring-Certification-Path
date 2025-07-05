package com.spring.security.example8.controllers;


import com.spring.security.example8.dao.CustomerDao;
import com.spring.security.example8.ds.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

import static com.spring.security.example7.security.SecurityRoles.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDao customersDao;

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_READ') || hasRole('ROLE_CUSTOMERS_QA')")
    @GetMapping("/customers")
    public ModelAndView index() {
        return new ModelAndView("customers8", "customers", customersDao.findAll());
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_READ') || hasRole('ROLE_CUSTOMERS_QA')")
    @GetMapping("/customers/view/{customerId}")
    public ModelAndView view(@PathVariable int customerId) {
        return new ModelAndView("customer-view8", "customer", customersDao.findById(customerId));
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_CREATE') || hasRole('ROLE_CUSTOMERS_QA')")
    @GetMapping("/customers/create")
    public ModelAndView create() {
        return new ModelAndView("customer-create8", "customer", new Customer());
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_CREATE') || hasRole('ROLE_CUSTOMERS_QA')")
    @PostMapping("/customers/create")
    public String create(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-create8";
        } else {
            customersDao.saveAll(new LinkedList<>(Collections.singletonList(customer)));

            return "redirect:/customers";
        }
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_DELETE') || hasRole('ROLE_CUSTOMERS_QA')")
    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customersDao.delete(
                customersDao.findById(id).orElse(null));

        return "redirect:/customers";
    }
}
