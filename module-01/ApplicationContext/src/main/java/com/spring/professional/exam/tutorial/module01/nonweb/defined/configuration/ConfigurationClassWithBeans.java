package com.spring.professional.exam.tutorial.module01.nonweb.defined.configuration;


import com.spring.professional.exam.tutorial.module01.nonweb.beans.SpringBean1;
import com.spring.professional.exam.tutorial.module01.nonweb.beans.SpringBean2;
import com.spring.professional.exam.tutorial.module01.nonweb.beans.SpringBean3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClassWithBeans {
    @Bean(name = "springBean1")
    public SpringBean1 getSpringBean1() {
        return new SpringBean1();
    }

    @Bean
    public SpringBean2 getSpringBean2() {
        return new SpringBean2();
    }

    @Bean
    public SpringBean3 getSpringBean3() {
        return new SpringBean3();
    }


}
