package com.certification.spring.aop.example7.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DepartmentRepositoryAspect {

    @Pointcut("@within(com.certification.spring.aop.example7.annotations.MonitoredRepository)")
    public void annotationWithinPointcut() {}

    @Before("annotationWithinPointcut()")
    public void beforeAnnotationWithinExample1() {
        System.out.println("Before - annotation within example 1");
    }

    @Before("@target(com.certification.spring.aop.example7.annotations.MonitoredRepository)")
    public void beforeAnnotationTargetExample1() {
        System.out.println("Before - annotation target example 1");
    }
}
