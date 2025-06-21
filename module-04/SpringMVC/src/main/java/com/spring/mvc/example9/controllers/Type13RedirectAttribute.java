package com.spring.mvc.example9.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Type13RedirectAttribute {

    @GetMapping("/actionM1")
    public String actionM1(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("firstName", "Praj");
        redirectAttributes.addFlashAttribute("lastName", "S");
        redirectAttributes.addFlashAttribute("city", "BN");

        return "redirect:/actionM2";
    }

    @GetMapping("/actionM2")
    public String actionM2(@RequestParam("firstName") String firstName, @ModelAttribute("lastName") String lastname, @ModelAttribute("city") String city, Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("myCity", city);
        return "list-attributes";
    }
}
