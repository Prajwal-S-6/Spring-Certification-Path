package com.spring.mvc.example9.controllers;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class Type16UriComponentBuilder {

    @GetMapping("/actionP")
    public String actionP(HttpServletRequest servletRequest) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(servletRequest.getRequestURI() + "?" + servletRequest.getQueryString())
                .scheme("https")
                .replaceQueryParam("lastName", "S")
                .build();

        return String.format("Created new request from UriComponentBuilder %s", uriComponents.toString());
    }
}
