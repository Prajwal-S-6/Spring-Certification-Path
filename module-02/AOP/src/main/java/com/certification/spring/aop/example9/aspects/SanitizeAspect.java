package com.certification.spring.aop.example9.aspects;

import com.certification.spring.aop.example9.annotations.Sanitize;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Component
@Aspect
public class SanitizeAspect {

    @Around("execution(* com..*.*(*, ..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        try {
            proceedingJoinPoint.proceed(sanitizeArgumentsIfRequired(proceedingJoinPoint.getArgs(), methodSignature));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] sanitizeArgumentsIfRequired(Object[] args, MethodSignature methodSignature) {
        Object[] filteredArgs = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            filteredArgs[i] = sanitizeArgumentIfRequired(
                    args[i],
                    methodSignature.getMethod().getParameterAnnotations()[i]
            );
        }
        return filteredArgs;
    }

    private Object sanitizeArgumentIfRequired(Object arg, Annotation[] parameterAnnotations) {
        if (containsAnnotationOfType(parameterAnnotations, Sanitize.class) && arg.getClass() == String.class)
            return "***sanitized***";
        else
            return arg;
    }

    private boolean containsAnnotationOfType(Annotation[] parameterAnnotations, Class sanitizeClass) {
        return Arrays.stream(parameterAnnotations)
                .map(Annotation::annotationType)
                .anyMatch(sanitizeClass::equals);
    }
}
