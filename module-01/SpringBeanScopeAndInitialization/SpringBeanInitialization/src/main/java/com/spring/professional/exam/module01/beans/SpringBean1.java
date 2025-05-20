package com.spring.professional.exam.module01.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean1 {
    public SpringBean1() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Singleton Bean");
    }
}
