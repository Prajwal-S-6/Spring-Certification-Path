package com.spring.rest.example14.controllers;

import jakarta.servlet.http.Cookie;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/controller5")
public class Controller5 {

    @GetMapping("/method1")
    public String method1(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        return String.format("RequestParam1: %s, RequestParam2: %s", param1, param2);
    }

    @GetMapping("/method2/{var1}/{var2}")
    public String method2(@PathVariable("var1") String var1, @PathVariable("var2") String var2) {
        return String.format("PathVariable1: %s, PathVariable2: %s", var1, var2);
    }

    @GetMapping("/method3/employees/{matVar}")
    public String method3(@MatrixVariable(pathVar = "matVar", name = "name") String var1, @MatrixVariable(pathVar = "matVar", name = "id") String var2) {
        return String.format("MatrixVariable1: %s, MatrixVariable2: %s", var1, var2);
    }

    @GetMapping("/method4")
    public String method4(@CookieValue(value = "cookie1") String cookie1, @CookieValue(value = "cookie2")Cookie cookie2) {
        return String.format("Cookie1: %s, Cookie2 name: %s, Cookie2 Value: %s", cookie1, cookie2.getName(), cookie2.getValue());
    }

    @GetMapping("/method5")
    public String method5(@RequestHeader(name = "header1") String header1, @RequestHeader Map<String, String> headers) {
        return String.format("Header1: %s, All headers: %s", header1, headers);
    }
}
