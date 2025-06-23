package com.spring.mvc.example11.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Controller
public class Type03HttpHeaders {

    @GetMapping("/actionC1")
    public HttpHeaders actionC1() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("custom-header", "custom-header-value");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(System.currentTimeMillis());

        return httpHeaders;
    }
}
