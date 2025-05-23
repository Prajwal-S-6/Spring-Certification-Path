package com.spring.professional.exam.tutorial.module01.nonweb;


import com.spring.professional.exam.tutorial.module01.nonweb.beans.SpringBean1;
import com.spring.professional.exam.tutorial.module01.nonweb.defined.configuration.ConfigurationClassWithBeans;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextExample1b {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConfigurationClassWithBeans.class
        );

        SpringBean1 bean = (SpringBean1) context.getBean("springBean1");

        bean.sayHello();

        context.close();
    }
}
