package com.spring.mvc.example9.controllers;

import com.spring.mvc.example9.dao.AddressDao;
import com.spring.mvc.example9.ds.Address;
import com.spring.mvc.example9.ds.Country;
import com.spring.mvc.example9.ds.Person;
import com.spring.mvc.example9.ds.ShortAddress;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"person", "shortAddress", "country"})
public class Type15SessionAttributeSessionStatus {

    @Autowired
    private AddressDao addressDao;

    @GetMapping("/actionO")
    public String actionO(Model model) {
        model.addAttribute("addresses", addressDao.findAll());
        return "addresses-list";
    }

    @GetMapping("/actionO1")
    public String actionO1(@ModelAttribute("person") Person person) {
        return "address-form-step1";
    }

    @PostMapping("/actionO1")
    public String addPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "address-form-step1";
        }

        return "redirect:/actionO2";
    }

    @GetMapping("/actionO2")
    public String actionO2(@ModelAttribute("shortAddress") ShortAddress address) {
        return "address-form-step2";
    }

    @PostMapping("/actionO2")
    public String addAddress(@ModelAttribute("shortAddress") @Valid ShortAddress shortAddress, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "address-form-step2";
        }

        return "redirect:/actionO3";
    }

    @GetMapping("/actionO3")
    public String actionO3(@ModelAttribute("country") Country country) {
        return "address-form-step3";
    }

    @PostMapping("/actionO3")
    public String actionSubmit(@ModelAttribute("country") @Valid Country country, BindingResult bindingResult, @ModelAttribute("shortAddress") ShortAddress shortAddress, @ModelAttribute("person") Person person, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors())
            return "address-form-step3";
        else {
            Address address = new Address(person, shortAddress, country);
            addressDao.save(address);
            sessionStatus.setComplete();

            return "redirect:/actionO";
        }
    }


    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @ModelAttribute("shortAddress")
    public ShortAddress shortAddress() {
        return new ShortAddress();
    }

    @ModelAttribute("country")
    public Country country() {
        return new Country();
    }
}
