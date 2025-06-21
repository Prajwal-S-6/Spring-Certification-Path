package com.spring.mvc.example9.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class Type12MapModelModelMap {

    @GetMapping("/actionL1")
    public String actionL1(Map<String, String> map) {
        map.put("firstName", "John");
        map.put("lastName", "Doe");
        map.put("email", "John.Doe@corp.com");
        map.put("city", "Los Angeles");

        return "address";
    }


    @GetMapping("/actionL2")
    public String actionL2(Model model) {
        model.addAttribute("firstName", "John");
        model.addAttribute("lastName", "Doe");
        model.addAttribute("email", "John.Doe@corp.com");
        model.addAttribute("city", "Los Angeles");

        return "address";
    }

    @GetMapping("/actionL3")
    public String actionL2(ModelMap modelMap) {
        modelMap.addAttribute("firstName", "John");
        modelMap.addAttribute("lastName", "Doe");
        modelMap.addAttribute("email", "John.Doe@corp.com");
        modelMap.addAttribute("city", "Los Angeles");

        return "address";
    }

}
