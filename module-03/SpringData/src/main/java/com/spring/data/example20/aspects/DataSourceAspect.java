package com.spring.data.example20.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@Aspect
public class DataSourceAspect {
    private static Set<String> LOGGABLE_METHODS = new HashSet<>(Arrays.asList(
            "commit", "rollback", "close"
    ));

    @Around("target(javax.sql.DataSource)")
    public Object aroundDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Data Source Trace: " + joinPoint.getSignature());

        Object returnObject = joinPoint.proceed();
        if (returnObject instanceof Connection) {
            return createConnectionProxy((Connection) returnObject);
        } else
            return returnObject;
    }

    private Connection createConnectionProxy(Connection connection) {
        return (Connection) Proxy.newProxyInstance(
                DataSourceAspect.class.getClassLoader(),
                new Class[]{Connection.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (shouldLogInvocation(method))
                            System.out.println("Connection Trace: " + method.toGenericString());

                        return method.invoke(connection, args);
                    }
                }
        );
    }

    private boolean shouldLogInvocation(Method method) {
        return LOGGABLE_METHODS.contains(method.getName());
    }
}
