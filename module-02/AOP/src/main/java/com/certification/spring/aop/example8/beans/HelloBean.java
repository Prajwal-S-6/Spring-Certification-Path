package com.certification.spring.aop.example8.beans;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class HelloBean {
    public String formatData(String firstName, String lastName) {
        return String.format("%s %s", firstName, lastName);
    }

    public void saveData(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
    }
}
