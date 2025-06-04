package com.certification.spring.aop.example6;

import com.certification.spring.aop.example6.aspects.HelloBeanAspect;
import com.certification.spring.aop.example6.beans.HelloBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@EnableAspectJAutoProxy
public class ApplicationConfig {

    @Bean
    public HelloBeanAspect helloBeanAspect() {
        return new HelloBeanAspect();
    }

    @Bean
    HelloBean helloBean() {
        return new HelloBean();
    }
}
