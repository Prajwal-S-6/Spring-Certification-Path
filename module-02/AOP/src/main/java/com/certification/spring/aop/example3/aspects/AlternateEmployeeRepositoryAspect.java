package com.certification.spring.aop.example3.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AlternateEmployeeRepositoryAspect {

    @Before("execution(* com.certification.spring.aop.example3.service.b.AlternateEmployeeRepository.findEmployeeById(..))")
    public void beforeServiceBFindByEmployee() {
        System.out.println("Service B - beforeServiceBFindByEmployee");
    }
}
