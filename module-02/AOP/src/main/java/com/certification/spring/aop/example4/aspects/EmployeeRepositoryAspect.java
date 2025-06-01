package com.certification.spring.aop.example4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeRepositoryAspect {

    @Pointcut("within(com.certification.spring.aop.example4.service.*.*) || within(com.certification.spring.aop.example4.*)")
    public void withinServicesOrSamePackagePointcut() {}

    @Before("withinServicesOrSamePackagePointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("Before - " + joinPoint.getSignature());
    }
}
