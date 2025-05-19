package com.spring.professional.exam.tutorial.module01.context.beans;

import org.springframework.stereotype.Component;

@Component
class Wheels {
    void roll() {
        System.out.println("Wheels are rolling");
    }
}
