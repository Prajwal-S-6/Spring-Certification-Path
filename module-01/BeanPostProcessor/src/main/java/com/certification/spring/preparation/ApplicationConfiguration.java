package com.certification.spring.preparation;

import com.certification.spring.preparation.beans.SpringBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class ApplicationConfiguration {

    @Bean(initMethod = "initMethod")
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }
}
