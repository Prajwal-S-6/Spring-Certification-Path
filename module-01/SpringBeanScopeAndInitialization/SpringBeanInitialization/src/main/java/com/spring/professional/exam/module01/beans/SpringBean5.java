package com.spring.professional.exam.module01.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SpringBean5 {
    public SpringBean5() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Singleton Bean");
    }
}
