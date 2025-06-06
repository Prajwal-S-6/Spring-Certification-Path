package com.certification.spring.aop.example7.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloBeanAspect {

    @Before("execution(public !int com..HelloBean.say*(*, *))")
    public void executionExample1() {
        System.out.println("Before - execution example 1");
    }
}
