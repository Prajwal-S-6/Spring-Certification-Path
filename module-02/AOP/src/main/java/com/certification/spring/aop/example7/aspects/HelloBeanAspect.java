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

    @After("execution(void *..HelloChildBean.*(com.certification.spring.aop.example7.ds.Person))")
    public void executionExample4() {
        System.out.println("After - execution example 4");
    }

    @Before("within(com.certification.spring.aop.example7.beans.HelloChildBean)")
    public void withinExample1() {
        System.out.println("Before - within example 1");
    }

    @Before("within(com..*)")
    public void withinExample2() {
        System.out.println("Before - within example 2");
    }

    @Before("within(com..Hello*)")
    public void withinExample3() {
        System.out.println("Before - within example 3");
    }


    @Before("args(*)")
    public void argsExample1() {
        System.out.println("Before - args example 1");
    }

    @Before("args(String)")
    public void argsExample2() {
        System.out.println("Before - args example 2");
    }

    @Before("args(com.certification.spring.aop.example7.ds.Person)")
    public void argsExample3() {
        System.out.println("Before - args example 3");
    }

    @Before("args(String, *)")
    public void argsExample4() {
        System.out.println("Before - args example 4");
    }

    @Before("args(String, ..)")
    public void argsExample5() {
        System.out.println("Before - args example 5");
    }

    @Before("bean(hello_child_bean)")
    public void beanExample1() {
        System.out.println("Before - bean example 1");
    }

    @Before("bean(helloChildBean)")
    public void beanExample2() {
        System.out.println("Before - bean example 2");
    }

    @Before("bean(hello*)")
    public void beanExample3() {
        System.out.println("Before - bean example 3");
    }

    @Before("bean(taxBean1)")
    public void beanExample4() {
        System.out.println("Before - bean example 4");
    }




}
