package com.spring.mvc.example9.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Type5HttpSession {

    @GetMapping("/actionE")
    public String actionE(HttpSession httpSession) {
        Integer counter = (Integer) httpSession.getAttribute("counter");

        if(counter == null) {
            httpSession.setAttribute("counter", 0);
            counter = 0;
        }

        httpSession.setAttribute("counter", counter++);
        return String.format("Retrieved session attribute from HttpSession. Counter: %s", counter);
    }
}
