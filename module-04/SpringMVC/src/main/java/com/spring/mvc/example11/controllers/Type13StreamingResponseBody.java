package com.spring.mvc.example11.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;

import static com.spring.mvc.example11.utils.SleepUtil.sleep;

@Controller
public class Type13StreamingResponseBody {

    @GetMapping("/actionM")
    public StreamingResponseBody actionM1() {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                outputStream.write("Praj".getBytes());
                try {
                    sleep();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                outputStream.write("S".getBytes());
            }
        };
    }
}
