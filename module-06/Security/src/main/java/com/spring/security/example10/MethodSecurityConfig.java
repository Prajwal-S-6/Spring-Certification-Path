package com.spring.security.example10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

@Configuration
@EnableMethodSecurity
public class MethodSecurityConfig {

    @Bean
    public RoleHierarchy roleHierarchy() {
        return RoleHierarchyImpl.withRolePrefix("MY_ROLE_")
                .role("ADMIN").implies("READ")
                .role("ADMIN").implies("WRITE")
                .role("ADMIN").implies("DELETE")
                .build();
    }

    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler(RoleHierarchy roleHierarchy) {
        return new CustomMethodSecurityExpressionHandler(roleHierarchy, "MY_ROLE_");
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("MY_ROLE_");
    }

}
