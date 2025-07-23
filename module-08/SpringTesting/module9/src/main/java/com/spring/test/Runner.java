package com.spring.test;

import com.spring.test.application.ApplicationService;
import com.spring.test.configuration.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        context.registerShutdownHook();

        ApplicationService applicationService = context.getBean(ApplicationService.class);
        System.out.println(applicationService.listGuests());
    }
}
