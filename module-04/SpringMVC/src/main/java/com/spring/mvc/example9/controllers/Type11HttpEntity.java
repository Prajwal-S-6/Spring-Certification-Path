package com.spring.mvc.example9.controllers;

import com.spring.mvc.example9.ds.Address;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Type11HttpEntity {

    @GetMapping("/actionK")
    public String actionK(HttpEntity<Address> addressHttpEntity) {
        return String.format("Retrieved from HttpEntity %s, %s",
                addressHttpEntity.getHeaders(),
                addressHttpEntity.getBody());
    }
}
