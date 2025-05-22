package com.certification.spring.preparation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

    @Autowired
    private SpringBean1 springBean1;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${db.host}")
    private String dbHostName;

    public String getApplicationName() {
        return applicationName;
    }

    public String getDbHostName() {
        return dbHostName;
    }

    public void useProperty() {
        springBean1.usePropertyValue(applicationName);
    }


}
