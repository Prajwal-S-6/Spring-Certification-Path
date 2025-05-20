package com.spring.professional.exam.tutorial.module01.closing.context.runners;

import com.spring.professional.exam.tutorial.module01.closing.context.ApplicationConfiguration;
import com.spring.professional.exam.tutorial.module01.closing.context.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner3 {

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.getBean(SpringBean1.class);
        }
    }
}
