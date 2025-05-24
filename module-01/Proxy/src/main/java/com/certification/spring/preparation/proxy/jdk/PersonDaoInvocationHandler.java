package com.certification.spring.preparation.proxy.jdk;


import com.certification.spring.preparation.dao.PersonDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonDaoInvocationHandler implements InvocationHandler {

    private final PersonDao target;

    public PersonDaoInvocationHandler(PersonDao target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("before " + method.getName());
        System.out.println(obj.getClass().getSimpleName());
        Object result = method.invoke(target, args);
        System.out.println("after " + method.getName());
        return result;
    }
}
