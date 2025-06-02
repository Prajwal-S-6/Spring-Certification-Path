package com.certification.spring.aop.example5.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeRepositoryAspect {

    @Pointcut("execution(* com.certification.spring.aop.example5.repository.*.*(..))")
    public void methodsExecutionPointcut() {}

    @Before("methodsExecutionPointcut()")
    public void beforeAllMethodExecution(JoinPoint joinPoint) {
        System.out.println("Before - " + joinPoint.getSignature());
    }

    @After("methodsExecutionPointcut()")
    public void afterAllMethodExecution(JoinPoint joinPoint) {
        System.out.println("After - " + joinPoint.getSignature());
    }

    @AfterThrowing(value = "methodsExecutionPointcut()", throwing = "exception")
    public void afterThrowingException(JoinPoint joinPoint, Exception exception) {
        System.out.println(String.format("After throwing exception %s from %s", exception, joinPoint.getSignature()));
    }

    @AfterReturning(value = "methodsExecutionPointcut()", returning = "returnValue")
    public void afterReturningValue(JoinPoint joinPoint, Object returnValue) {
        System.out.println(String.format("After successful execution of method %s and returning value %s", joinPoint.getSignature(), returnValue));
    }


}
