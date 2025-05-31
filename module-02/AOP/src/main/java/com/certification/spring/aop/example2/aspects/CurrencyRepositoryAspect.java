package com.certification.spring.aop.example2.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CurrencyRepositoryAspect {

    @Pointcut("this(com.certification.spring.aop.example2.bls.CurrenciesRepository)")
    public void thisCurrencyRepositoryPointcut() {

    }

    @Before("thisCurrencyRepositoryPointcut()")
    public void beforeThisCurrencyRepositoryPointcut() {
        System.out.println("Before - this(CurrenciesRepository)");
    }



}
