package com.spring.professional.exam.tutorial.module01;

import com.spring.professional.exam.tutorial.module01.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.getBean(SpringBean1.class);
        }
    }
}
