package com.spring.security.example8.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import static com.spring.security.example8.security.SecurityRoles.*;

@Configuration
public class RoleHierarchyConfiguration {

    @Bean("roleHierarchy")
    public RoleHierarchy roleHierarchy() {
        return RoleHierarchyImpl.withDefaultRolePrefix()
                .role(CUSTOMERS_ADMIN).implies(CUSTOMERS_CREATE)
                .role(CUSTOMERS_ADMIN).implies(CUSTOMERS_DELETE)
                .role(CUSTOMERS_ADMIN).implies(CUSTOMERS_READ)
                .build();

    }
}
