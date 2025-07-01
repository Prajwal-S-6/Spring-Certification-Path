package com.spring.security.example1.controllers;

import com.spring.security.example1.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeDao employeesDao;


}
