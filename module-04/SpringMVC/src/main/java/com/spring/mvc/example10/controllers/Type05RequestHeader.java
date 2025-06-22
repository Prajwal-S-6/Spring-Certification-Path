package com.spring.mvc.example10.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class Type05RequestHeader {

    @GetMapping("/actionE1")
    public String actionE1(@RequestHeader("Accept-Language") String requestHeader) {
        return String.format("Request Header: %s", requestHeader);
    }

    @GetMapping("/actionE2")
    public String actionE2(@RequestHeader(value = "Accept-Language", required = false) String requestHeader) {
        return String.format("Request Header: %s", requestHeader);
    }

    @GetMapping("/actionE3")
    public String actionE3(@RequestHeader(value = "Accept-Language", defaultValue = "N/A") String requestHeader) {
        return String.format("Request Header: %s", requestHeader);
    }

    @GetMapping("/actionE4")
    public String actionE4(@RequestHeader(value = "Accept-Language") Optional<String> requestHeader) {
        return String.format("Request Header: %s", requestHeader.orElse("Optional"));
    }

    @GetMapping("/actionE5")
    public String actionE5(@RequestHeader Map<String, String> requestHeadersMap) {
        return String.format("Request Header map: %s", requestHeadersMap);
    }


}
