package com.spring.professional.exam.tutorial.dependencyInjection.annotations.advanced;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "com.spring.professional.exam.tutorial.dependencyInjection.annotations.beans",
        //basePackageClasses = SpringBean1.class,
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Bean.*"),  // includes all beans with Class name as *Bean.*
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Bean1.*") // excludes all beans with class name as *Bean1.*
)
public class ApplicationConfigurationAdvanced {
}
