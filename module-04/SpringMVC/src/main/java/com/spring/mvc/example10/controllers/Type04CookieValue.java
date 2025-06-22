package com.spring.mvc.example10.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Type04CookieValue {

    @GetMapping("/set-cookie")
    public String setCookie(HttpServletResponse httpServletResponse) {
        httpServletResponse.addCookie(new Cookie("cookie-value", "06"));
        return "Cookie set successfully";
    }

    @GetMapping("/actionD1")
    public String actionD1(@CookieValue("cookie-value") String cookieValue) {
        return String.format("Cookie value: %s", cookieValue);
    }

    @GetMapping("/actionD2")
    public String actionD2(@CookieValue("cookie-value") Cookie cookieValue) {
        return String.format("Cookie name: %s, Cookie value: %s",cookieValue.getName(), cookieValue.getValue());
    }

    @GetMapping("/actionD3")
    public String actionD3(@CookieValue(value = "cookie-value1", required = false) String cookieValue) {
        return String.format("Cookie value: %s", cookieValue);
    }

    @GetMapping("/actionD4")
    public String actionD4(@CookieValue(value = "cookie-value1", defaultValue = "N/A") String cookieValue) {
        return String.format("Cookie value: %s", cookieValue);
    }

    @GetMapping("/actionD5")
    public String actionD5(@CookieValue(value = "cookie-value1") Optional<String> cookieValue) {
        return String.format("Cookie value: %s", cookieValue.orElse("N/A optional"));
    }
}
