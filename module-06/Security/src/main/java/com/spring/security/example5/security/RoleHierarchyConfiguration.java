package com.spring.security.example5.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import static com.spring.security.example2.security.SecurityRoles.*;

@Configuration
public class RoleHierarchyConfiguration {

    @Bean("roleHierarchy")
    public RoleHierarchy roleHierarchy() {
        return RoleHierarchyImpl.withDefaultRolePrefix()
                .role(SUPER_ADMIN).implies(CUSTOMERS_ADMIN)
                .role(CUSTOMERS_ADMIN).implies(CUSTOMERS_CREATE)
                .role(CUSTOMERS_ADMIN).implies(CUSTOMERS_READ)
                .role(CUSTOMERS_ADMIN).implies(CUSTOMERS_DELETE)
                .role(CUSTOMERS_ADMIN).implies(CUSTOMERS_PAG_VIEW)

                .role(SUPER_ADMIN).implies(DEPARTMENTS_ADMIN)
                .role(DEPARTMENTS_ADMIN).implies(DEPARTMENTS_PAG_VIEW)
                .role(DEPARTMENTS_ADMIN).implies(DEPARTMENTS_CREATE)
                .role(DEPARTMENTS_ADMIN).implies(DEPARTMENTS_READ)
                .role(DEPARTMENTS_ADMIN).implies(DEPARTMENTS_DELETE)

                .role(SUPER_ADMIN).implies(EMPLOYEES_ADMIN)
                .role(EMPLOYEES_ADMIN).implies(EMPLOYEES_PAG_VIEW)
                .role(EMPLOYEES_ADMIN).implies(EMPLOYEES_CREATE)
                .role(EMPLOYEES_ADMIN).implies(EMPLOYEES_READ)
                .role(EMPLOYEES_ADMIN).implies(EMPLOYEES_DELETE)
                .build();

    }
}
