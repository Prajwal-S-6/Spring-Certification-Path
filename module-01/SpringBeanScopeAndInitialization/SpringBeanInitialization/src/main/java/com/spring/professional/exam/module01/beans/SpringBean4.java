package com.spring.professional.exam.module01.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
///  eagerly loads beans even if @ComponentScan(lazyInit=true)
@Lazy(value = false)
public class SpringBean4 {

    public SpringBean4() {
        System.out.println("Creating " + getClass().getSimpleName() + " - Singleton Bean");
    }
}
