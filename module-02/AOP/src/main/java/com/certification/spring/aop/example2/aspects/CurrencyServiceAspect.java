package com.certification.spring.aop.example2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CurrencyServiceAspect {
    @Pointcut("@annotation(com.certification.spring.aop.example2.annotations.InTransaction)")
    public void transactionAnnotationPointcut() {
    }

    @Pointcut("within(com.certification.spring.aop.example2.bls.*)")
    public void blsPackagePointcut() {
    }

    @Pointcut("@within(com.certification.spring.aop.example2.annotations.Secured)")
    public void securedClassPointcut() {
    }

    // execution(returnType com.some.package.SomeClass.someMethod(...))
    @Pointcut("execution(float com.certification.spring.aop.example2.bls.CurrencyService.getExchangeRate(..))")
    public void getExchangeRateMethodPointcut() {
    }

    @Pointcut("bean(currency_service)")
    public void namedBeanPointcut() {
    }

    @Pointcut("args(String, String, int)")
    public void stringsAndIntegerArgumentsMethodPointcut() {
    }

    @Pointcut("@args(com.certification.spring.aop.example2.annotations.Validated)")
    public void validatedArgumentPointcut() {
    }

    @Pointcut("target(com.certification.spring.aop.example2.bls.CurrencyService)")
    public void currencyServiceTargetPointcut() {
    }

    @Pointcut("@target(com.certification.spring.aop.example2.annotations.Secured)")
    public void currencyServiceSecuredTargetPointcut() {
    }

    @Pointcut("this(com.certification.spring.aop.example2.bls.CurrencyService)")
    public void currencyServiceThisPointcut() {
    }

    @Pointcut("blsPackagePointcut() && transactionAnnotationPointcut()")
    public void blsPackageAndInTransactionPointcut() {
    }

    @Before("transactionAnnotationPointcut()")
    public void beforeTransactionAnnotationAdvice() {
        System.out.println("Before - transactionAnnotationPointcut");
    }

    @Before("blsPackagePointcut()")
    public void beforeBlsPackageAdvice() {
        System.out.println("Before - blsPackagePointcut");
    }

    @After("blsPackagePointcut()")
    public void afterBlsPackageAdvice() {
        System.out.println("After - blsPackagePointcut");
    }

    @Before("securedClassPointcut()")
    public void beforeSecuredClassAdvice() {
        System.out.println("Before - securedClassPointcut");
    }

    @Around("getExchangeRateMethodPointcut()")
    public Object aroundSecuredClassAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            System.out.println("Before - getExchangeRateMethodPointcut");
            return proceedingJoinPoint.proceed();
        } finally {
            System.out.println("After - getExchangeRateMethodPointcut");
        }
    }

    @After("namedBeanPointcut()")
    public void afterNamedBeanAdvice() {
        System.out.println("After - namedBeanPointcut");
    }

    @After("stringsAndIntegerArgumentsMethodPointcut()")
    public void afterStringsAndIntegerArgumentsMethodAdvice() {
        System.out.println("After - stringsAndIntegerArgumentsMethodPointcut");
    }

    @After("validatedArgumentPointcut()")
    public void afterValidatedArgumentAdvice() {
        System.out.println("After - validatedArgumentPointcut");
    }

    @After("currencyServiceTargetPointcut()")
    public void afterCurrencyServiceTargetAdvice() {
        System.out.println("After - currencyServiceTargetPointcut");
    }

    @After("currencyServiceSecuredTargetPointcut()")
    public void afterCurrencyServiceSecuredTargetAdvice() {
        System.out.println("After - currencyServiceSecuredTargetPointcut");
    }

    @After("currencyServiceThisPointcut()")
    public void afterCurrencyServiceThisAdvice() {
        System.out.println("After - currencyServiceThisPointcut");
    }

    @After("blsPackageAndInTransactionPointcut()")
    public void afterBlsPackageAndInTransactionAdvice() {
        System.out.println("After - blsPackageAndInTransactionPointcut");
    }

    @AfterThrowing(value = "execution(* com.certification.spring.aop.example2.bls.CurrencyService.getCurrencyCountryName(..))", throwing = "exception")
    public void afterThrowingException(Exception exception) {
        System.out.println("Exception was thrown from getCurrencyCountryName: " + exception.getClass().getSimpleName());
    }

    @AfterReturning(value = "execution(* com.certification.spring.aop.example2.bls.CurrencyService.getCurrencyCountryName(..))", returning = "value")
    public void afterThrowingException(String value) {
        System.out.println("Value returned from getCurrencyCountryName: " + value);
    }
}
