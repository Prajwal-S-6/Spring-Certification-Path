package com.spring.mvc.example10.controllers;

import com.spring.mvc.example10.ds.Country;
import com.spring.mvc.example10.ds.Person;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Type07RequestPart {

    @PostMapping("/actionG1")
    public String actionG1(@RequestPart("employee") String employee) {
        return String.format("RequestPart: %s", employee);
    }

    @PostMapping("/actionG2")
    public String actionG2(@RequestPart("person") Person person, @RequestPart("country") Country country) {
        return String.format("RequestPart- Person: %s, Country: %s", person, country);
    }

    @PostMapping("/actionG3")
    public String actionG3(@RequestPart("person") Person person, @RequestPart(value = "country", required = false) Country country) {
        return String.format("RequestPart- Person: %s, Country: %s", person, country);
    }

    @PostMapping("/actionG4")
    public String actionG4(@RequestPart("person") Person person, @RequestPart("country") Optional<Country> country) {
        return String.format("RequestPart- Person: %s, Country: %s", person, country.orElse(new Country()));
    }

    @PostMapping("/actionG5")
    public String actionG5(@RequestPart("person") @Valid Person person, BindingResult bindingResultPerson, @RequestPart("country") @Valid Country country, BindingResult bindingResultCountry) {
        return String.format("RequestPart- Person: %s, Country: %s, Errors person: %s, Errors country: %s", person, country, bindingResultPerson.getErrorCount(), bindingResultCountry.getErrorCount());
    }
}
