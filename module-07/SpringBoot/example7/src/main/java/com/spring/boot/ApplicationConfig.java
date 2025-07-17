package com.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring")
public class ApplicationConfig {

    private String propertyB;

    public String getPropertyB() {
        return propertyB;
    }

    public void setPropertyB(String propertyB) {
        this.propertyB = propertyB;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "propertyB='" + propertyB + '\'' +
                '}';
    }
}
