package com.certification.spring.aop.example3.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeRepositoryAspect {

    @Before("this(com.certification.spring.aop.example3.service.a.EmployeeRepository)")
    public void beforeThisEmployeeRepository() {
        System.out.println("Before - this(EmployeeRepository)");
    }

    @After("this(com.certification.spring.aop.example3.service.a.EmployeeRepository)")
    public void afterThisEmployeeRepository() {
        System.out.println("After - this(EmployeeRepository)");
    }

    @Before("execution(* com.certification.spring.aop.example3.service.a.EmployeeRepository.findEmployeeById(..))")
    public void beforeFindEmployeeById() {
        System.out.println("Service A - beforeFindEmployeeById");
    }

    @After("execution(* com.certification.spring.aop.example3.service.a.EmployeeRepository.findEmployeeById(..))")
    public void afterFindEmployeeById() {
        System.out.println("Service A - afterFindEmployeeById");
    }

    @After("within(com.certification.spring.aop.example3.service.a.*)")
    public void afterWithinServiceAPackage() {
        System.out.println("Service A - afterWithinServiceAPackage");
    }



}
