package com.certification.spring.aop.example4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class EmployeeRepositoryAspect {
    
    Logger LOG = LoggerFactory.getLogger(EmployeeRepositoryAspect.class);

    @Pointcut("within(com.certification.spring.aop.example4.service.*.*) || within(com.certification.spring.aop.example4.*)")
    public void withinServicesOrSamePackagePointcut() {}

    @Before("withinServicesOrSamePackagePointcut()")
    public void before(JoinPoint joinPoint){
        LOG.info("Before - " + joinPoint.getSignature().getName());
    }

    @After("withinServicesOrSamePackagePointcut()")
    public void after(JoinPoint joinPoint){
        LOG.info("After - " + joinPoint.getSignature().getName());
    }
}
