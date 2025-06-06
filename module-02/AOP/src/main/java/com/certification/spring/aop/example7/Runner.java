package com.certification.spring.aop.example7;

import com.certification.spring.aop.example7.beans.HelloBean;
import com.certification.spring.aop.example7.beans.HelloChildBean;
import com.certification.spring.aop.example7.ds.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        HelloChildBean springBean = context.getBean(HelloChildBean.class);
        springBean.sayHello("John", 5);
        springBean.validateName("Jane");
        springBean.saveCounterValue(7);
        springBean.savePerson(new Person());
    }
}
