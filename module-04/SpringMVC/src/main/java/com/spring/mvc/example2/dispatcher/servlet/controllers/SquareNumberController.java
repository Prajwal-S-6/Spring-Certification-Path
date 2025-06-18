package com.spring.mvc.example2.dispatcher.servlet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc")
public class SquareNumberController {

    @GetMapping("square-number")
    public String squareNumber(@RequestParam("number") int number, Model model) {
        model.addAttribute("number", number);
        model.addAttribute("numberSquare", number * number);
        return "square-number";
    }
}
