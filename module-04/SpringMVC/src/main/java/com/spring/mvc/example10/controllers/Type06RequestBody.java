package com.spring.mvc.example10.controllers;

import com.spring.mvc.example10.ds.Person;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Type06RequestBody {

    @PostMapping("/actionF1")
    public String actionF1(@RequestBody String requestBody) {
        return String.format("RequestBody: %s", requestBody);
    }

    @PostMapping("/actionF2")
    public String actionF2(@RequestBody Person requestBody) {
        return String.format("RequestBody: %s", requestBody.toString());
    }

    @PostMapping("/actionF3")
    public String actionF3(@RequestBody(required = false) Person requestBody) {
        return String.format("RequestBody: %s", requestBody);
    }

    @PostMapping("/actionF4")
    public String actionF4(@RequestBody Optional<Person> requestBody) {
        return String.format("RequestBody: %s", requestBody.orElse(new Person()));
    }


    @PostMapping("/actionF5")
    public String actionF5(@RequestBody @Valid Person requestBody, BindingResult bindingResult) {
        return String.format("RequestBody: %s, Error count: %s", requestBody, bindingResult.getErrorCount());
    }

}
