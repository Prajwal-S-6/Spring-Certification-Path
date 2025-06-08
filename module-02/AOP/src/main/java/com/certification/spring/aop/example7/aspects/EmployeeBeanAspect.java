package com.certification.spring.aop.example7.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeBeanAspect {

    // @Before("execution(* com..EmployeeBean.get*(..)) || execution(* com..EmployeeBean.set*(..))")
    @Before("within(com..EmployeeBean) && (execution(* com..EmployeeBean.get*(..)) || execution(* com..EmployeeBean.set*(..)))")
    public void beforeAllGetterSetters(JoinPoint joinPoint) {
        System.out.println("Before - all getter, setter from EmployeeBean " + joinPoint.getSignature());
    }
}
