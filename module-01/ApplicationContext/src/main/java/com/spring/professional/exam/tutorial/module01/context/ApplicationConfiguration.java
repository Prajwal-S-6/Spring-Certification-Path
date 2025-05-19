package com.spring.professional.exam.tutorial.module01.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean
    String someBean() {
        return "Test";
    }
}
