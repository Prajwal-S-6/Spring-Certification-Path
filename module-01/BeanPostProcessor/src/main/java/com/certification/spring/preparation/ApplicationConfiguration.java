package com.certification.spring.preparation;

import com.certification.spring.preparation.beans.SpringBean1;
import com.certification.spring.preparation.beans.SpringBean2;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@ComponentScan
public class ApplicationConfiguration {

    @Bean
    public static CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }

    @Bean(initMethod = "initMethod")
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }

    @Bean(destroyMethod = "destroyMethod")
    public SpringBean2 springBean2() {
        return new SpringBean2();
    }
}
