package com.spring.mvc.example10.controllers;

import com.spring.mvc.example10.dao.AddressDao;
import com.spring.mvc.example10.ds.Address;
import com.spring.mvc.example10.ds.Country;
import com.spring.mvc.example10.ds.Person;
import com.spring.mvc.example10.ds.ShortAddress;
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
import org.springframework.web.bind.support.SimpleSessionStatus;

import java.util.List;

@Controller
@SessionAttributes({"person", "shortAddress", "country"})
public class Type11SessionAttributes {

    @Autowired
    private AddressDao addressDao;


    @GetMapping("/actionK1")
    public String actionK(Model model) {
        model.addAttribute("addresses", addressDao.findAll());
        return "addresses-list10";
    }

    @GetMapping("/actionK2")
    public String actionK2(@ModelAttribute("person")Person person) {
        return "address-form10-step1";
    }

    @PostMapping("/actionK2")
    public String actionK2(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "address-form10-step1";
        }
        return "redirect:/actionK3";
    }

    @GetMapping("/actionK3")
    public String actionK3(@ModelAttribute("shortAddress")ShortAddress shortAddress) {
        return "address-form10-step2";
    }

    @PostMapping("/actionK3")
    public String actionK3(@ModelAttribute("shortAddress") @Valid ShortAddress shortAddress, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "address-form10-step2";
        }

        return "redirect:/actionK4";
    }

    @GetMapping("/actionK4")
    public String actionK4(@ModelAttribute Country country) {
        return "address-form10-step3";
    }

    @PostMapping("/actionK4")
    public String actionK4(@ModelAttribute("country") @Valid Country country, BindingResult bindingResult, @ModelAttribute("person") Person person, @ModelAttribute("shortAddress") ShortAddress shortAddress, SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return "address-form10-step3";
        }

        addressDao.save(new Address(person, shortAddress, country));
        sessionStatus.setComplete();

        return "redirect:/actionK1";
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
