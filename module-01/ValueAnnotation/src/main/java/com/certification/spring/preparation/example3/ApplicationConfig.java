package com.certification.spring.preparation.example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@ComponentScan
public class ApplicationConfig {

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }
}
