package com.certification.spring.aop.example1.with.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Aspect
public class PerformanceLoggerAspect {

    private static final Logger LOG = LoggerFactory.getLogger(PerformanceLoggerAspect.class);

    @Around("@annotation(com.certification.spring.aop.example1.with.aop.annotations.PerformanceLogger)")
    public Object addPerformanceLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            long finishTime = System.currentTimeMillis();
            Duration duration = Duration.ofMillis(finishTime - startTime);

            LOG.info(String.format("Duration of %s execution was %s", proceedingJoinPoint.getSignature(), duration));
        }
    }
}
