package com.spring.security.example10;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.EvaluationContext;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

public class CustomMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler  {

    private final RoleHierarchy roleHierarchy;
    private final String rolePrefix;

    public CustomMethodSecurityExpressionHandler(RoleHierarchy roleHierarchy, String rolePrefix) {
        this.roleHierarchy = roleHierarchy;
        this.rolePrefix = rolePrefix;

        this.setRoleHierarchy(roleHierarchy);
        this.setDefaultRolePrefix(rolePrefix);
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation) {
        CustomSecurityExpressionRoot customSecurityExpressionRoot = new CustomSecurityExpressionRoot(authentication);
        customSecurityExpressionRoot.setTarget(invocation.getThis());
        return customSecurityExpressionRoot;
    }

    @Override
    public EvaluationContext createEvaluationContext(Supplier<Authentication> authentication, MethodInvocation mi) {
        return createEvaluationContext(authentication.get(), mi);
    }
}
