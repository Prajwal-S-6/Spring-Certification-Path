package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource()
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
