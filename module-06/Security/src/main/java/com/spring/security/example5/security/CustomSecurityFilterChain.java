package com.spring.security.example5.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityFilterChain {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                .anyRequest().authenticated())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                        .loginPage("/login")
                        .failureUrl("/login-error")
                        .permitAll())
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                        .logoutSuccessUrl("/login")
                        .logoutUrl("/logout").permitAll());

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails john = User.withUsername("john")
                .password(encoder.encode("john"))
                .authorities("ROLE_SUPER_ADMIN", "CUSTOMERS_READ", "CUSTOMERS_PAG_VIEW")
                .build();

        UserDetails emma = User.withUsername("emma")
                .password(encoder.encode("emma"))
                .roles("EMPLOYEES_ADMIN")
                .build();

        UserDetails william = User.withUsername("william")
                .password(encoder.encode("william"))
                .authorities("DEPARTMENTS_PAG_VIEW", "DEPARTMENTS_READ", "DEPARTMENTS_CREATE")
                .build();

        UserDetails lucas = User.withUsername("lucas")
                .password(encoder.encode("lucas"))
                .authorities("CUSTOMERS_READ", "CUSTOMERS_PAG_VIEW")
                .build();

        UserDetails tom = User.withUsername("tom")
                .password(encoder.encode("tom"))
                .roles()
                .build();

        return new InMemoryUserDetailsManager(john, emma, william, lucas, tom);
    }



}
