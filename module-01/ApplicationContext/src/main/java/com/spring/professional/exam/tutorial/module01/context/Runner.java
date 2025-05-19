package com.spring.professional.exam.tutorial.module01.context;

import com.spring.professional.exam.tutorial.module01.context.beans.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {
    public static void main(String... args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            Car car = context.getBean(Car.class);
            // System.out.println(context.getBean(String.class));
            car.drive();
        }
    }
}
