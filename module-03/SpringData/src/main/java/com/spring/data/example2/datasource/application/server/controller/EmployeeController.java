package com.spring.data.example2.datasource.application.server.controller;

import com.spring.data.example2.datasource.application.server.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping
    @ResponseBody
    public String emails() {
        return String.join(",", employeeDao.findEmployeeEmails());
    }
}
