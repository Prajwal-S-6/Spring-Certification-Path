package com.spring.mvc.example11.controllers;

import com.spring.mvc.example11.ds.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import java.util.Locale;

@Controller
public class Type05View {

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @GetMapping("/actionE1")
    public View actionE1() throws Exception {
        return thymeleafViewResolver.resolveViewName("hello11", Locale.ENGLISH);
    }

    @GetMapping("/actionE2")
    public View actionE2(Model model) throws Exception {
        model.addAttribute("person", new Person());
        return thymeleafViewResolver.resolveViewName("person11", Locale.getDefault());
    }

    @PostMapping("/actionE2")
    public View actionE2(@ModelAttribute("person") Person person, Model model) throws Exception {
        model.addAttribute("submit", true);
        return thymeleafViewResolver.resolveViewName("person11", Locale.getDefault());
    }


}
