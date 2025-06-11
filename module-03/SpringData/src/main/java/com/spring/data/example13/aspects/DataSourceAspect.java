package com.spring.data.example13.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

@Component
@Aspect
public class DataSourceAspect {

    @Around("target(javax.sql.DataSource)")
    public Object aroundDataSource(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Data Source Trace: " + proceedingJoinPoint.getSignature());

        Object returnObject = proceedingJoinPoint.proceed();
        if(returnObject instanceof Connection) {
            return createConnectionProxy((Connection) returnObject);
        }
        return returnObject;
    }

    private Object createConnectionProxy(Connection connection) {
        return Proxy.newProxyInstance(DataSourceAspect.class.getClassLoader(),
                new Class[]{Connection.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Connection Trace: " + method.toGenericString());
                        return method.invoke(connection, args);
                    }
                }
        );
    }
}
