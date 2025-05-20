package com.spring.professional.exam.module01;

import com.spring.professional.exam.module01.beans.SpringBean6;
import com.spring.professional.exam.module01.beans.SpringBean7;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
//@ComponentScan(lazyInit = true)
// @Lazy
public class ApplicationConfiguration {

    @Bean
    public SpringBean6 springBean6() {
        return new SpringBean6();
    }

    @Bean
    @Lazy
    public SpringBean7 springBean7() {
        return new SpringBean7();
    }
}
