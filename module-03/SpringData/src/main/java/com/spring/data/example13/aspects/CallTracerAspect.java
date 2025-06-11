package com.spring.data.example13.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracerAspect {

    @Pointcut("within(com.spring.data.example13.service)")
    public void callTracePointcut() {}

    @Around("callTracePointcut()")
    public Object traceMethodCalls(ProceedingJoinPoint proceedingJoinPoint) {
        Object returnValue = null;
        String methodName = proceedingJoinPoint.getSignature().getName();

        try {
            System.out.println("Starting " + methodName);
            returnValue = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println(String.format("Exception thrown from %s: %s", methodName, throwable.getMessage()));
        }

        System.out.println("Completed " + methodName);
        return returnValue;
    }
}
