package com.spring.security.example1.security;

import org.springframework.context.ApplicationContext;
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
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static com.spring.security.example1.security.SecurityRoles.*;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcBuilder = new MvcRequestMatcher.Builder(introspector);

        httpSecurity
                .authorizeHttpRequests(auth -> auth
                .requestMatchers(mvcBuilder.pattern("/"), mvcBuilder.pattern("/home")).permitAll()
                .requestMatchers(mvcBuilder.pattern("/employee")).hasRole(EMPLOYEES_PAG_VIEW)
                .requestMatchers(mvcBuilder.pattern("/department")).hasRole(DEPARTMENTS_PAG_VIEW)
                .requestMatchers(mvcBuilder.pattern("/customer")).hasRole(CUSTOMERS_PAG_VIEW)
                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .failureUrl("/login-error")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll());

        return httpSecurity.build();

    }

    @Bean
    public HandlerMappingIntrospector introspector(ApplicationContext context) {
        return new HandlerMappingIntrospector();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails john = User.withUsername("john")
                .password(encoder.encode("john"))
                .roles("SUPER_ADMIN")
                .build();

        UserDetails emma = User.withUsername("emma")
                .password(encoder.encode("emma"))
                .roles("EMPLOYEES_ADMIN")
                .build();

        UserDetails william = User.withUsername("william")
                .password(encoder.encode("william"))
                .roles("DEPARTMENTS_PAG_VIEW", "DEPARTMENTS_READ", "DEPARTMENTS_CREATE")
                .build();

        UserDetails lucas = User.withUsername("lucas")
                .password(encoder.encode("lucas"))
                .roles("CUSTOMERS_PAG_VIEW", "CUSTOMERS_READ")
                .build();

        UserDetails tom = User.withUsername("tom")
                .password(encoder.encode("tom"))
                .roles()
                .build();

        return new InMemoryUserDetailsManager(john, emma, william, lucas, tom);
    }

}
