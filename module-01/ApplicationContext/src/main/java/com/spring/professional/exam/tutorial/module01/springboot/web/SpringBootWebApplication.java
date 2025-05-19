package com.spring.professional.exam.tutorial.module01.springboot.web;

import com.spring.professional.exam.tutorial.module01.nonweb.beans.SpringBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
