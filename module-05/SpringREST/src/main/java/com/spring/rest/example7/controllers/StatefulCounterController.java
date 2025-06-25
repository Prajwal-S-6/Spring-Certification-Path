package com.spring.rest.example7.controllers;

import com.spring.rest.example7.ds.CounterServiceResponse;
import com.spring.rest.example7.service.MutableCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatefulCounterController {
    @Autowired
    private MutableCounter mutableCounter;

    @PostMapping("/counter/stateful")
    public CounterServiceResponse counter() {
        mutableCounter.countUp();

        return new CounterServiceResponse(mutableCounter.getNumber());
    }
}
