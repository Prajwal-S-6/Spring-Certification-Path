package com.spring.security.example7.security;

import org.springframework.beans.factory.annotation.Qualifier;
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

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/home").permitAll()
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .failureUrl("/login-error")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()).build();
    }

    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(@Qualifier("passwordEncoder") PasswordEncoder encoder) {
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
                .roles("CUSTOMERS_READ", "CUSTOMERS_PAG_VIEW")
                .build();

        UserDetails tom = User.withUsername("tom")
                .password(encoder.encode("tom"))
                .roles()
                .build();

        return new InMemoryUserDetailsManager(john, emma, william, lucas, tom);
    }
}
