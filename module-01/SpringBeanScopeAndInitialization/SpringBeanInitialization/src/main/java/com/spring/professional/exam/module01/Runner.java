package com.spring.professional.exam.module01;

import com.spring.professional.exam.module01.beans.SpringBean7;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.getBean(SpringBean7.class);
        }
    }
}
