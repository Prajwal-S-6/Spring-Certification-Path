package com.spring.mvc.example11.controllers;

import com.spring.mvc.example10.ds.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Type02HttpEntityAndResponseEntity {

    @GetMapping("/actionB1")
    public HttpEntity<Person> actionB1() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("custom-header", "custom-header-value");

        return new HttpEntity<>(new Person("Praj", "S"), httpHeaders);
    }

    @GetMapping("/actionB2")
    public ResponseEntity<Person> actionB2() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("custom-header", "custom-header-value");

        return new ResponseEntity<>(new Person("Praj", "S"), httpHeaders, HttpStatus.FOUND);
    }

}
