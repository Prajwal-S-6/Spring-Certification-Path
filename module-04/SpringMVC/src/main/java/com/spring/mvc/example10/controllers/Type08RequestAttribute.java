package com.spring.mvc.example10.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class Type08RequestAttribute {

    @GetMapping("/actionH1")
    public String actionH1(@RequestAttribute("processing-time") String attribute) {
        return String.format("RequestPart: %s", attribute);
    }

    @GetMapping("/actionH2")
    public String actionH2(@RequestAttribute("processing-time") LocalDateTime localDateTime) {
        return String.format("RequestPart: %s", localDateTime);
    }

    @GetMapping("/actionH3")
    public String actionH3(@RequestAttribute(value = "some-processing-time", required = false) LocalDateTime localDateTime) {
        return String.format("RequestPart: %s", localDateTime);
    }

    @GetMapping("/actionH4")
    public String actionH4(@RequestAttribute("some-processing-time") Optional<LocalDateTime> localDateTime) {
        return String.format("RequestPart: %s", localDateTime.orElse(LocalDateTime.MAX));
    }
}
