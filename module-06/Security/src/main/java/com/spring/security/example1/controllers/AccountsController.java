package com.spring.security.example1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountsController {

    @GetMapping("/accounts")
    public String accounts() {
        return "account1";
    }
}
