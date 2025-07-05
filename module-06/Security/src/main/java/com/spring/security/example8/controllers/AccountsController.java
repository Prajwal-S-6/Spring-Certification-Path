package com.spring.security.example8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountsController {

    @GetMapping("/account")
    public String accounts() {
        return "account8";
    }
}
