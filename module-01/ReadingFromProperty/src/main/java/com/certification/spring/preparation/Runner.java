package com.certification.spring.preparation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        SpringBean bean = context.getBean(SpringBean.class);
        System.out.println(bean.getApplicationName());
        System.out.println(bean.getDbHostName());
    }
}
