package com.spring.security.example3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static com.spring.security.example3.security.SecurityRoles.*;

@Configuration
public class FilterChainConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        MvcRequestMatcher.Builder mvcRequestMatcher = new MvcRequestMatcher.Builder(new HandlerMappingIntrospector());
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers(mvcRequestMatcher.pattern("/"), mvcRequestMatcher.pattern("/home")).permitAll()
                .requestMatchers(mvcRequestMatcher.pattern("/departments")).hasRole(DEPARTMENTS_PAG_VIEW)
                .requestMatchers(mvcRequestMatcher.pattern("/customers")).hasRole(CUSTOMERS_PAG_VIEW)
                .requestMatchers(mvcRequestMatcher.pattern("/employees")).hasRole(EMPLOYEES_PAG_VIEW)
                .anyRequest().authenticated())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                        .loginPage("/login")
                        .failureUrl("/login-error").permitAll())
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll());

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
