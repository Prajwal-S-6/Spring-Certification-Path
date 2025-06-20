package com.spring.mvc.example8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ApiController {

    @GetMapping("{name}")
    @ResponseBody
    public String actionA(@PathVariable String name) {
        return String.format("PathVariable name: %s", name);
    }

    @GetMapping("/actionB/city/{city}")
    @ResponseBody
    public String actionB(@PathVariable(name = "city") String city) {
        return String.format("PathVariable city: %s", city);
    }

    @GetMapping("/actionC/country/{countries}/city/{city}")
    @ResponseBody
    public String actionC(@PathVariable(value = "countries") String country, @PathVariable(name = "city") String city) {
        return String.format("PathVariable. country: %s, city: %s",country, city);
    }

    @GetMapping({"/actionD/country/{countries}/city/{city}", "/actionD/country/{countries}"})
    @ResponseBody
    public String actionD(@PathVariable(value = "countries") String country, @PathVariable(name = "city", required = false) String city) {
        return String.format("PathVariable city not required. country: %s, city: %s",country, city);
    }

    @GetMapping({"/actionE/country/{countries}/city/{city}", "/actionE/country/{countries}"})
    @ResponseBody
    public String actionE(@PathVariable(value = "countries") String country, @PathVariable(name = "city") Optional<String> city) {
        return String.format("PathVariable optional value. country: %s, city: %s",country, city.orElse("NY"));
    }


    @GetMapping("/actionF/country/{countries}/city/{city}/zip/{zipCode}")
    @ResponseBody
    public String actionF(@PathVariable Map<String, String> pathMap) {
        return String.format("PathVariable map. country: %s, city: %s, zip: %s", pathMap.get("countries"), pathMap.get("city"), pathMap.get("zipCode"));
    }

    @GetMapping("/actionG/countries/{countries}")
    @ResponseBody
    public String actionG(@PathVariable("countries") List<String> countries) {
        return String.format("PathVariable List: %s", String.join(",", countries));
    }

}
