package com.spring.professional.exam.module01.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SpringBean3 {
    private SpringBean2 springBean2;

    public SpringBean3(SpringBean2 springBean2) {
        System.out.println("Creating " + getClass().getSimpleName() + " - Exception case: Singleton Bean dependent on prototype bean SpringBean2");
    }
}
