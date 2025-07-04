package com.spring.security.example6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FavIcoController {

    @RequestMapping("favicon.ico")
    @ResponseBody
    public void noFavIcon() {
        //
    }
}
