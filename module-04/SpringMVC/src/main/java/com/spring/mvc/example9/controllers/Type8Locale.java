package com.spring.mvc.example9.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Type8Locale {

    @GetMapping("/actionH")
    public String actionH(Locale locale) {
        return String.format("Retrieved from Locale: %s, %s, %s", locale.getDisplayLanguage(), locale.getDisplayCountry(), locale.getDisplayName());
    }
}
