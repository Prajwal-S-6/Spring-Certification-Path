package com.certification.spring.aop.example8.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class HelloBeanAspect {

    @Before("execution(* com..HelloBean.formatData(String, String))")
    public void beforeHelloBean(JoinPoint joinPoint) {
        System.out.println("HelloBeanAspect::beforeHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("this = " + joinPoint.getThis());
        System.out.println("target = " + joinPoint.getTarget());

        System.out.println("HelloBeanAspect::beforeHelloBean <- stop\n\n");
    }

    @After("execution(* com..HelloBean.formatData(String, String))")
    public void afterHelloBean(JoinPoint joinPoint) {
        System.out.println("HelloBeanAspect::beforeHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("this = " + joinPoint.getThis());
        System.out.println("target = " + joinPoint.getTarget());

        System.out.println("HelloBeanAspect::beforeHelloBean <- stop\n\n");
    }
}
