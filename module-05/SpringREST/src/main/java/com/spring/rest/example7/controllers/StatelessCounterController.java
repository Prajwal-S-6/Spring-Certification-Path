package com.spring.rest.example7.controllers;

import com.spring.rest.example7.ds.CounterServiceRequest;
import com.spring.rest.example7.ds.CounterServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatelessCounterController {

    @PostMapping("/counter")
    public CounterServiceResponse counter(@RequestBody CounterServiceRequest counterServiceRequest) {
        return new CounterServiceResponse(counterServiceRequest.getNumber() + 1);
    }
}
