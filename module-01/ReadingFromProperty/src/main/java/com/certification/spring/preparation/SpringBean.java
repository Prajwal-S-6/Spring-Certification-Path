package com.certification.spring.preparation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

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


}
