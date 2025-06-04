package com.certification.spring.aop.example6;

import com.certification.spring.aop.example6.beans.HelloBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        HelloBean helloBean = context.getBean(HelloBean.class);
        helloBean.sayHello();
    }
}
