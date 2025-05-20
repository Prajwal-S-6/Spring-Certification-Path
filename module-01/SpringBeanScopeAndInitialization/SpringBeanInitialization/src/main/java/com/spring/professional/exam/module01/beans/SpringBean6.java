package com.spring.professional.exam.module01.beans;

import org.springframework.stereotype.Component;

public class SpringBean6 {
    public SpringBean6() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Bean from Configuration class");
    }
}
