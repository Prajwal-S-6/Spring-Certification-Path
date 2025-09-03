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
public class AlternativeCurrenciesRepositoryAspect {

    Logger LOG = LoggerFactory.getLogger(AlternativeCurrenciesRepositoryAspect.class);

    @Pointcut("this(com.certification.spring.aop.example2.bls.AlternativeCurrenciesRepository)")
    private void thisAlternativeCurrencyRepositoryPointcut() {}

    @Before("thisAlternativeCurrencyRepositoryPointcut()")
    public void beforeThisCurrenciesRepository() {
        LOG.info("Before - this(AlternativeCurrenciesRepository)");
    }

    @Before("target(com.certification.spring.aop.example2.bls.AlternativeCurrenciesRepository)")
    public void beforeTargetCurrenciesRepository() {
        LOG.info("Before - target(AlternativeCurrenciesRepository)");
    }

    @Before("bean(alternate_currencies)")
    public void beforeBeanCurrenciesRepository() {
        LOG.info("Before - bean(AlternativeCurrenciesRepository)");
    }

    @After("bean(alternate_currencies)")
    public void afterBeanCurrenciesRepository() {
        LOG.info("After - bean(AlternativeCurrenciesRepository)");
    }
}
