package com.spring.professional.exam.tutorial.module01.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean3 {
    public SpringBean3() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + "::postConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(getClass().getSimpleName() + "::preDestroy");
    }
}
