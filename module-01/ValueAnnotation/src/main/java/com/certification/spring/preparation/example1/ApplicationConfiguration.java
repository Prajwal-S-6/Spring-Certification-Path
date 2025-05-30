package com.certification.spring.preparation.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Bean
    public ConversionService conversionService() {
        return new DefaultConversionService();
    }

}
