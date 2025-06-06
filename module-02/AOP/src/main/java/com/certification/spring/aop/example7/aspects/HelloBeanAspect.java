package com.certification.spring.aop.example7.aspects;

import org.aspectj.lang.annotation.After;
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

    @Before("execution(* *..*.*(..) throws java.io.IOException)")
    public void executionExample2() {
        System.out.println("Before - execution example 2");
    }

    @After("execution(void com..HelloChildBean.*(.., !com.certification.spring.aop.example7.ds.Person))")
    public void executionExample3() {
        System.out.println("After - execution example 3");
    }


}
