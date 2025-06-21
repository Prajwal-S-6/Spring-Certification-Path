package com.spring.mvc.example9.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class Type10Stream {

    @GetMapping("/actionJ")
    // public void actionI(Reader inputStream, Writer outputStream) throws IOException {
    public void actionI(InputStream inputStream, OutputStream outputStream) throws IOException {
        inputStream.transferTo(outputStream);
        outputStream.write(10);
    }
}
