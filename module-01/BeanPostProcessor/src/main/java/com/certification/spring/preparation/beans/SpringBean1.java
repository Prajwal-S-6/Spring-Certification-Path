package com.certification.spring.preparation.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;



public class SpringBean1 implements InitializingBean {

    @PostConstruct
    public void postConstruct() {
        System.out.println(getClass().getSimpleName() + "::postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(getClass().getSimpleName() + " InitializingBean::afterPropertiesSet");
    }

    public void initMethod() {
        System.out.println(getClass().getSimpleName() + "::initMethod");
    }
}
