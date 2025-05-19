package com.spring.professional.exam.tutorial.module01.nonweb;


import com.spring.professional.exam.tutorial.module01.nonweb.beans.SpringBean1;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextExample2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.spring.professional.exam.tutorial.module01.nonweb.beans"
        );

        SpringBean1 bean = (SpringBean1) context.getBean(SpringBean1.class);

        bean.sayHello();
    }
}
