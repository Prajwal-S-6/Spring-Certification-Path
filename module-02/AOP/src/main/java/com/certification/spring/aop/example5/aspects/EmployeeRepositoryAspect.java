package com.certification.spring.aop.example5.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeRepositoryAspect {

    @Before("execution(* com.certification.spring.aop.example5.repository.*.*(..))")
    public void beforeAllMethodExecution(JoinPoint joinPoint) {
        System.out.println("Before - " + joinPoint.getSignature());
    }

    @After("execution(* com.certification.spring.aop.example5.repository.*.*(..))")
    public void afterAllMethodExecution(JoinPoint joinPoint) {
        System.out.println("After - " + joinPoint.getSignature());
    }
}
