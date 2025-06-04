package com.certification.spring.aop.example6.beans;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    public void sayHello() {
        System.out.println("Hello from Spring bean");
    }
}
