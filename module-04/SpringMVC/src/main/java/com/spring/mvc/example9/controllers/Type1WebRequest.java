package com.spring.mvc.example9.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import static com.spring.mvc.example9.utils.JoinUtils.join;

@RestController
public class Type1WebRequest {

    @GetMapping("/actionA")
    public String actionA(WebRequest webRequest) {
        return String.format("Request with headers and request params: Headers: %s, Params: %s", join(webRequest.getHeaderNames()), join(webRequest.getParameterNames()));
    }
}
