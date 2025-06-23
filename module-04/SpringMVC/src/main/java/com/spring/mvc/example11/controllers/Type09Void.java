package com.spring.mvc.example11.controllers;

import jakarta.servlet.ServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.io.OutputStream;

@Controller
public class Type09Void {

    @GetMapping("/actionI1")
    public void actionI1(ServletResponse servletResponse) throws IOException {
        servletResponse.getOutputStream().println("Returning void - ServletResponse is print the output");
    }

    @GetMapping("/actionI2")
    public void actionI2(OutputStream outputStream) throws IOException {
        outputStream.write("returning void".getBytes());
    }

    @GetMapping("/actionI3")
    @ResponseStatus(HttpStatus.FOUND)
    public void actionI3() {

    }

    @GetMapping("/example11actionI4")
    public void actionI4() {

    }


}
