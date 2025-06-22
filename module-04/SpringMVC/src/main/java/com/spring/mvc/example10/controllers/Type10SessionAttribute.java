package com.spring.mvc.example10.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@RestController
public class Type10SessionAttribute {

    @GetMapping("/actionJ1")
    public String setSessionAttribute(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("session-attribute", "06");
        return "Session attribute set successfully";
    }

    @GetMapping("/actionJ2")
    public String actionJ2(@SessionAttribute(name = "session-attribute") String attribute) {
        return String.format("SessionAttribute: %s", attribute);
    }

    @GetMapping("/actionJ3")
    public String actionJ3(@SessionAttribute(value = "some-session-attribute", required = false) String attribute) {
        return String.format("SessionAttribute: %s", attribute);
    }

    @GetMapping("/actionJ4")
    public String actionJ4(@SessionAttribute(value = "some-session-attribute") Optional<String> attribute) {
        return String.format("SessionAttribute: %s", attribute.orElse("N/A"));
    }
}
