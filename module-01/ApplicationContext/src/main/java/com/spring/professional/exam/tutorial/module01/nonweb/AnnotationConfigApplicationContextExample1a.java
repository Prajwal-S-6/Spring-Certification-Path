package com.spring.professional.exam.tutorial.module01.nonweb;


import com.spring.professional.exam.tutorial.module01.nonweb.beans.ConfigurationComponentScan;
import com.spring.professional.exam.tutorial.module01.nonweb.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextExample1a {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConfigurationComponentScan.class
        );

        SpringBean1 bean = context.getBean(SpringBean1.class);

        bean.sayHello();

        context.close();
    }


}
