package com.spring.rest.example7.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CounterServiceRequest {
    private int number;

    public CounterServiceRequest(@JsonProperty("number") int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
