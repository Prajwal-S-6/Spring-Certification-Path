package com.spring.boot.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {

    public void print(){
        System.out.println("This is service from same package as @SpringBootApplication");
    }
}
