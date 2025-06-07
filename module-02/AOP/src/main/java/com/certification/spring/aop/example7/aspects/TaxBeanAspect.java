package com.certification.spring.aop.example7.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TaxBeanAspect {

    @Before("this(com.certification.spring.aop.example7.beans.ITaxBean)")
    public void thisExample1() {
        System.out.println("Before - this example 1");
    }

    @Before("this(com.certification.spring.aop.example7.beans.TaxBean1)")
    public void thisExample2() {
        System.out.println("Before - this example 2");
    }

    @Before("this(com.certification.spring.aop.example7.beans.TaxBean2)")
    public void thisExample3() {
        System.out.println("Before - this example 3");
    }

    @Before("target(com.certification.spring.aop.example7.beans.ITaxBean)")
    public void targetExample1() {
        System.out.println("Before - target example 1");
    }

    @Before("target(com.certification.spring.aop.example7.beans.TaxBean1)")
    public void targetExample2() {
        System.out.println("Before - target example 2");
    }

    @Before("target(com.certification.spring.aop.example7.beans.TaxBean2)")
    public void targetExample3() {
        System.out.println("Before - target example 3");
    }


}
