package com.spring.mvc.example10.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class Type03MatrixVariable {

    @GetMapping("/actionC1/{id}")
    public String actionC1(@MatrixVariable("id") String id) {
        return String.format("MatrixVariable - id: %s", id);
    }

    @GetMapping("/actionC2/employees/{employee}")
    public String actionC2(@MatrixVariable(pathVar = "employee", name = "id") String id, @MatrixVariable("name") String name) {
        return String.format("MatrixVariable - id: %s, name: %s", id, name);
    }

    @GetMapping("/actionC3/employees/{employee}/cities/{city}")
    public String actionC3(@MatrixVariable(pathVar = "employee", name = "id") String id, @MatrixVariable(pathVar = "employee",  name="name", required = false) String name,
                           @MatrixVariable(pathVar = "city", value = "code") String cityCode, @MatrixVariable(pathVar = "city", value = "location") Optional<String> location) {
        return String.format("MatrixVariable - id: %s, name: %s, city: %s, location: %s", id, name, cityCode, location.orElse("N/A"));
    }

    @GetMapping("/actionC4/employees/{employee}")
    public String actionC4(@MatrixVariable Map<String, String> employeeMap) {
        return String.format("MatrixVariable - employee map: %s", employeeMap);
    }


    @GetMapping("/actionC5/employees/{employee}/cities/{city}")
    public String actionC5(@MatrixVariable Map<String, String> employeeCityMap) {
        return String.format("MatrixVariable - employee city map: %s", employeeCityMap);
    }

    @GetMapping({"/actionC6/employees/{employee}/cities/{city}", "/actionC6/employees/{employee}/cities" })
    public String actionC6(@MatrixVariable(pathVar = "employee") Map<String, String> employeeMap, @MatrixVariable(pathVar = "city", required = false) Map<String, String> cityMap) {
        return String.format("MatrixVariable - employee map: %s, city map: %s", employeeMap, cityMap);
    }


}
