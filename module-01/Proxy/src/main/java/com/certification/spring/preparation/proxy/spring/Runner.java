package com.certification.spring.preparation.proxy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        context.registerShutdownHook();

        context.getBean(SpringBean.class);
        context.getBean(SpringBean.class);
    }
}
