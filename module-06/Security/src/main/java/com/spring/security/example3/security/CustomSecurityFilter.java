package com.spring.security.example3.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CustomSecurityFilter extends OncePerRequestFilter {
    private Logger logger  = LoggerFactory.getLogger(CustomSecurityFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("This is Custom SecurityFilter");
        logger.info("Request URI - {}", request.getRequestURI());
        filterChain.doFilter(request, response);
    }
}
