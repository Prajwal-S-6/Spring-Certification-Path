package com.spring.professional.exam.tutorial.module01.context.beans;

import org.springframework.stereotype.Component;

@Component
class Engine {
    void start() {
        System.out.println("Engine is started");
    }
}
