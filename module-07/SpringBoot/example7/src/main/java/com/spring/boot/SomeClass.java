package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SomeClass {

    @Value("${spring.propertyA}")
    private String propertyA;

    @Autowired
    private Environment environment;

    public String getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(String propertyA) {
        this.propertyA = propertyA;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "propertyA='" + propertyA + '\'' +
                ", environment=" + environment.getProperty("spring.propertyC") +
                '}';
    }
}
