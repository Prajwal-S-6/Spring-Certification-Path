package com.spring.mvc.example9.controllers;

import jakarta.servlet.ServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Type3ServletRequest {

    @GetMapping("/actionC")
    public String actionC(ServletRequest servletRequest) {
        return String.format("Retrieved request info from ServletRequest. HostName: %s, Port: %s", servletRequest.getServerName(), servletRequest.getServerPort());
    }
}
