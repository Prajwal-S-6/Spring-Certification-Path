package com.spring.security.example6.controllers;


import com.spring.security.example6.dao.CustomersDao;
import com.spring.security.example6.ds.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;

    @GetMapping("/customers")
    public ModelAndView index() {
        return new ModelAndView("customers6", "customers", customersDao.findAll());
    }

    @GetMapping("/customers/create")
    public ModelAndView create() {
        return new ModelAndView("customer-create6", "customer", new Customer());
    }

    @PostMapping("/customers/create")
    public String create(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-create6";
        } else {
            customersDao.save(customer);

            return "redirect:/customers";
        }
    }

    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customersDao.deleteById(id);

        return "redirect:/customers";
    }
}
