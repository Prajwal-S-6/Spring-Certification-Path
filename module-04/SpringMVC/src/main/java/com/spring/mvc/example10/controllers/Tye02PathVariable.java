package com.spring.mvc.example10.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Tye02PathVariable {

    @GetMapping("actionB1/firstName/{firstName}/lastName/{lastName}")
    public String actionB1(@PathVariable(value = "firstName") String firstName, @PathVariable(name = "lastName") String lastName) {
        return String.format("PathVariable- firstName: %s, lastName: %s", firstName, lastName);
    }


    @GetMapping({"actionB2/firstName/{firstName}", "actionB2/firstName/{firstName}/lastName/{lastName}", "actionB2/firstName/{firstName}/lastName"})
    public String actionB2(@PathVariable(value = "firstName") String firstName, @PathVariable(name = "lastName", required = false) String lastName) {
        return String.format("PathVariable- firstName: %s, lastName: %s", firstName, lastName);
    }

    @GetMapping({"actionB3/firstName/{firstName}", "actionB3/firstName/{firstName}/lastName/{lastName}", "actionB3/firstName/{firstName}/lastName"})
    public String actionB3(@PathVariable(value = "firstName") String firstName, @PathVariable(name = "lastName") Optional<String> lastName) {
        return String.format("PathVariable- firstName: %s, lastName: %s", firstName, lastName.orElse("N/A"));
    }
}
