package com.spring.mvc.example9.controllers;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Type4ServletRequestAndResponse {

    @GetMapping("/actionD")
    public void actionD(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        servletResponse.getOutputStream().println(
                String.format("Retrived request from Servlet. Server: %s, Port: %s", servletRequest.getServerName(), servletRequest.getServerPort())
        );
    }
}
