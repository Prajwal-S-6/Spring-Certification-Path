package com.spring.security.example8.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.spring.security.example8.security.SecurityRoles.CUSTOMERS_ADMIN;
import static com.spring.security.example8.security.SecurityRoles.CUSTOMERS_QA;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/home").permitAll()
                .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .failureUrl("/login-error")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .logoutUrl("/logout")
                        .permitAll()).build();

    }

    @Bean
    public UserDetailsService userDetails(PasswordEncoder encoder) {
        UserDetails lucas = User.withUsername("lucas")
                .password(encoder.encode("lucas"))
                .roles(CUSTOMERS_ADMIN)
                .build();

        UserDetails tom = User.withUsername("tom")
                .password(encoder.encode("tom"))
                .roles(CUSTOMERS_QA)
                .build();

        return new InMemoryUserDetailsManager(lucas, tom);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
