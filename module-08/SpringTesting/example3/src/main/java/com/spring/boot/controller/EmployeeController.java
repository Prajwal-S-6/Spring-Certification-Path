package com.spring.boot.controller;


import com.spring.boot.dao.CityDao;
import com.spring.boot.dao.EmployeeDao;
import com.spring.boot.ds.EmployeePutRequest;
import com.spring.boot.ds.Employees;
import com.spring.boot.entity.City;
import com.spring.boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CityDao cityDao;

    @GetMapping("/employees")
    public Employees getEmployees() {
        return new Employees(employeeDao.findAll());
    }

    @PutMapping("/employees")
    public void putEmployee(@RequestBody EmployeePutRequest employeePutRequest) {
        String requestedCity = employeePutRequest.getCity();
        Optional<City> city = cityDao.findByName(requestedCity);

        City employeeCity = city.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Employee City [%s] not found", requestedCity))
        );

        employeeDao.save(new Employee(employeePutRequest.getName(), employeeCity));
    }
}
