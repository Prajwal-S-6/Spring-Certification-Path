package com.spring.mvc.example7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class ApiController {

    @GetMapping("/actionA")
    @ResponseBody
    public String actionA(@RequestParam("name") String name) {
        return String.format("RequestParam name: %s", name);
    }

    @GetMapping("/actionB")
    @ResponseBody
    public String actionB(@RequestParam("name") String name, @RequestParam(name = "city", required = false) String city) {
        return String.format("RequestParam name city not required. name: %s; city: %s", name, city);
    }

    @GetMapping("/actionC")
    @ResponseBody
    public String actionC(@RequestParam("name") String name, @RequestParam(value = "city") Optional<String> city) {
        return String.format("RequestParam name city optional. name: %s; city: %s", name, city.orElse(null));
    }

    @GetMapping("/actionD")
    @ResponseBody
    public String actionD(@RequestParam("name") String name, @RequestParam(name = "city", defaultValue = "NY") String city) {
        return String.format("RequestParam name city with default value. name: %s; city: %s", name, city);
    }

    @GetMapping("/actionE")
    @ResponseBody
    public String actionE(@RequestParam("name") String name, @RequestParam(name = "city") Optional<String> city) {
        return String.format("RequestParam name city with optional value. name: %s; city: %s", name, city.orElse("NY"));
    }

    @GetMapping("/actionF")
    @ResponseBody
    public String actionF(@RequestParam("name") String name, @RequestParam(name = "city") String city, @RequestParam(value = "zip") String zip) {
        return String.format("RequestParam. name: %s, city: %s, zip: %s", name, city, zip);
    }


}
