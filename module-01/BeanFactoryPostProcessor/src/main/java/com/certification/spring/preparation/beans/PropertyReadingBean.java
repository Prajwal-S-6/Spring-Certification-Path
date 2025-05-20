package com.certification.spring.preparation.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PropertyReadingBean {

    @Value("${spring.application.name}")
    private String applicationName;

    public String getApplicationName() {
        return applicationName;
    }
}
