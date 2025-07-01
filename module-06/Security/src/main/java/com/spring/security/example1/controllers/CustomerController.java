package com.spring.security.example1.controllers;

import com.spring.security.example1.dao.CustomerDao;
import com.spring.security.example1.ds.Customer;
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

import static com.spring.security.example1.security.SecurityRoles.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    // @Secured(ROLE_PREFIX + CUSTOMERS_PAG_VIEW)
    @PreAuthorize("hasAnyAuthority('CUSTOMERS_READ', 'CUSTOMERS_PAG_VIEW')")
    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", customerDao.findAll());
        return "customers1";
    }


    @GetMapping("/customers/create")
    @Secured(ROLE_PREFIX + CUSTOMERS_CREATE)
    public ModelAndView createCustomer() {
        return new ModelAndView("customer-create1", "customer", new Customer());
    }

    @PostMapping("/customers/create")
    @Secured(ROLE_PREFIX + CUSTOMERS_CREATE)
    public String createCustomer(@ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "customer-create1";
        } else {
            customerDao.save(customer);
            return "redirect:/customers";
        }
    }

    @GetMapping("/customers/delete/{id}")
    @Secured(ROLE_PREFIX + CUSTOMERS_DELETE)
    public String delete(@PathVariable Integer id) {
        customerDao.deleteById(id);

        return "redirect:/customers";
    }
}
