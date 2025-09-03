package com.certification.spring.aop.example2.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class CurrencyRepositoryAspect {
    
    Logger LOG = LoggerFactory.getLogger(CurrencyRepositoryAspect.class);

    @Pointcut("this(com.certification.spring.aop.example2.bls.CurrenciesRepository)")
    private void thisCurrencyRepositoryPointcut() {

    }

    @Before("thisCurrencyRepositoryPointcut()")
    public void beforeThisCurrencyRepositoryPointcut() {
        LOG.info("Before - this(CurrenciesRepository)");
    }

    @After("thisCurrencyRepositoryPointcut()")
    public void afterThisCurrencyRepositoryPointcut() {
        LOG.info("After - this(CurrenciesRepository)");
    }


    @Before("target(com.certification.spring.aop.example2.bls.CurrenciesRepository)")
    public void beforeTargetCurrencyRepositoryPointcut() {
        LOG.info("Before - target(CurrenciesRepository)");
    }

    @After("target(com.certification.spring.aop.example2.bls.CurrenciesRepository)")
    public void afterTargetCurrencyRepositoryPointcut() {
        LOG.info("After - target(CurrenciesRepository)");
    }



}
