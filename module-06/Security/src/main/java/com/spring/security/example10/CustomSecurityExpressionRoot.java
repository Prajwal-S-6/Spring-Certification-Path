package com.spring.security.example10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

public class CustomSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {
    private Object filterObject;
    private Object returnObject;
    private Object target;


    public CustomSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean isIdTwo(int id) {
        return id == 2;
    }


    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject =filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object getThis() {
        return this.target;
    }


}
