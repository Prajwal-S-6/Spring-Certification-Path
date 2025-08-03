package com.certification.spring.preparation;

import com.certification.spring.preparation.beans.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.security.MessageDigest;

@ComponentScan
@Configuration
public class ApplicationConfiguration {

    @Bean(initMethod = "init")
    public SpringBean1 springBean1(SpringBean2 springBean2, SpringBean3 springBean4) {
        return new SpringBean1(springBean2, springBean4);
    }

    @Bean(destroyMethod = "destroy")
    public SpringBean2 springBean2() {
        return new SpringBean2();
    }

    @Bean(name = "SpringBean3A")
    public SpringBean3A springBean3A(MessageDigest messageDigest) {
        return new SpringBean3A(messageDigest);
    }

    @Bean(name = {"SpringBean3B", "spring3BBean"}, autowireCandidate = false)
    public SpringBean3B springBean3B() {
        return new SpringBean3B();
    }

    @Bean(autowireCandidate = false)
    public SpringBean3C springBean3C() {
        return new SpringBean3C();
    }

    @Bean
    public MessageDigest messageDigest() {
        return DigestUtils.getSha384Digest();
    }
}
