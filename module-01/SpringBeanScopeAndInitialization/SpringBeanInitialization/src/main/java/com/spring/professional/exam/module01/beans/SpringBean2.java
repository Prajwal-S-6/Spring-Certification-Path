package com.spring.professional.exam.module01.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean2 {
    public SpringBean2() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Prototype Bean");
    }
}
