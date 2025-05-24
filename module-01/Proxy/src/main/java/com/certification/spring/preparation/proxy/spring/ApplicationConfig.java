package com.certification.spring.preparation.proxy.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@ComponentScan
@Configuration

// public final class ApplicationConfig {
public class ApplicationConfig {
    @Bean
    SpringBean springBean() {
        System.out.println("Creating SpringBean in " + getClass().getSimpleName());

        return new SpringBean();
    }
}
