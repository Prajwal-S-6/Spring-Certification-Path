package com.certification.spring.preparation.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean2 {

    public SpringBean2() {
        System.out.println("Constructor:" + getClass().getSimpleName());
    }
}
