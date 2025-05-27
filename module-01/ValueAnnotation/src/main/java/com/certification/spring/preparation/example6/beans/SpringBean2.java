package com.certification.spring.preparation.example6.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean2 {

    public static final String STATIC_VALUE = "staticFieldValue";
    public String property = "somePropertyValue";

    public static String staticMethod() {
        return "staticMethodValue";
    }

    public String method() {
        return "someMethod";
    }
}
