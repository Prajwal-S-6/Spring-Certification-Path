package com.certification.spring.aop.example5.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeRepositoryAspect {

    @Before("execution(* com.certification.spring.aop.example5.repository.*.*(..))")
    public void beforeAllMethodExecution() {
        System.out.println("Before - All method execution");
    }
}
