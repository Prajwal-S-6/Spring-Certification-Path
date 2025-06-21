package com.spring.mvc.example9.controllers;

import com.spring.mvc.example9.ds.Address;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Type14BindingResult {

    @GetMapping("/actionN1")
    public String actionN1(@ModelAttribute Address address) {
        return "address-form";
    }

    @PostMapping("/actionN1")
    public String actionN1Submit(@ModelAttribute @Valid Address address, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            return "address-form";
        }

        redirectAttributes.addFlashAttribute("myaddress", address);

        return "redirect:/actionN2";
    }

    @GetMapping("/actionN2")
    public String actionN1Ok() {
        return "address-form-ok";
    }
}
