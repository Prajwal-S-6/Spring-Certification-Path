package com.certification.spring.aop.example6.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class HelloBeanAspect {

    @Around("within(com.certification.spring.aop.example6.beans.*)")
    public void withinPackage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before - Around" + proceedingJoinPoint.getSignature());
        proceedingJoinPoint.proceed();
        System.out.println("After - Around" + proceedingJoinPoint.getSignature());
    }
}
