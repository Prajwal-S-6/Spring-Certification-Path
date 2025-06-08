package com.certification.spring.aop.example8.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
        System.out.println("HelloBeanAspect::afterHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("this = " + joinPoint.getThis());
        System.out.println("target = " + joinPoint.getTarget());

        System.out.println("HelloBeanAspect::afterHelloBean <- stop\n\n");
    }

    @AfterReturning(value = "execution(* com..HelloBean.formatData(String, String))", returning = "returnValue")
    public void afterReturningHelloBean(JoinPoint joinPoint, Object returnValue) {
        System.out.println("HelloBeanAspect::afterReturningHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("this = " + joinPoint.getThis());
        System.out.println("target = " + joinPoint.getTarget());

        System.out.println("Return value = " + returnValue);

        System.out.println("HelloBeanAspect::afterReturningHelloBean <- stop\n\n");

    }

    @AfterThrowing(value = "within(com..HelloBean)", throwing = "exception")
    public void afterThrowingHelloBean(JoinPoint joinPoint, Exception exception) {
        System.out.println("HelloBeanAspect::afterThrowingHelloBean <- start");

        System.out.println("Join Point = " + joinPoint.getStaticPart().toLongString());
        System.out.println("Signature = " + joinPoint.getSignature());
        System.out.println("Args = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Kind = " + joinPoint.getKind());
        System.out.println("this = " + joinPoint.getThis());
        System.out.println("target = " + joinPoint.getTarget());

        System.out.println("Exception message = " + exception.getMessage());

        System.out.println("HelloBeanAspect::afterThrowingHelloBean <- stop\n\n");
    }
}
