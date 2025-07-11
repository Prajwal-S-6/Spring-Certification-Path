package com.spring.security.example4.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class SecurityStrategyConfig implements InitializingBean {

    @Value("${spring.security.strategy}")
    private String securityStrategy;

    @Override
    public void afterPropertiesSet() throws Exception {
        SecurityContextHolder.setStrategyName(securityStrategy);
    }
}
