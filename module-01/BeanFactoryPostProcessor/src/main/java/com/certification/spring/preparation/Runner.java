package com.certification.spring.preparation;

import com.certification.spring.preparation.beans.PropertyReadingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();
        PropertyReadingBean propertyReadingBean = context.getBean(PropertyReadingBean.class);
        System.out.println(String.format("Application name: %s",propertyReadingBean.getApplicationName()));

    }

}
