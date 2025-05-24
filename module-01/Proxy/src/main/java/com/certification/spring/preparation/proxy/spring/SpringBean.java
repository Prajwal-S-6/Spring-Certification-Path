package com.certification.spring.preparation.proxy.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component
public class SpringBean {

    public SpringBean() {
        System.out.println("Spring bean: " + getClass().getSimpleName());
    }
}
