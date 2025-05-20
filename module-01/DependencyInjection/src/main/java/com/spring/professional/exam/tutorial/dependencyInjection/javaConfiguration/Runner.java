package com.spring.professional.exam.tutorial.dependencyInjection.javaConfiguration;

import com.spring.professional.exam.tutorial.dependencyInjection.javaConfiguration.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaApplicationConfiguration.class);
        context.registerShutdownHook();

        context.getBean(SpringBean1.class);
    }
}
