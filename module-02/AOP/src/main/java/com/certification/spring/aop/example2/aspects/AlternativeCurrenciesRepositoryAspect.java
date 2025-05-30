package com.certification.spring.aop.example2.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AlternativeCurrenciesRepositoryAspect {

    @Pointcut("this(com.certification.spring.aop.example2.bls.AlternativeCurrenciesRepository)")
    public void thisAlternativeCurrencyRepositoryPointcut() {}

    @Before("thisAlternativeCurrencyRepositoryPointcut()")
    public void beforeThisCurrenciesRepository() {
        System.out.println("Before - this(AlternativeCurrenciesRepository)");
    }
}
