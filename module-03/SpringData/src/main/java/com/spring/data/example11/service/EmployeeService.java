package com.spring.data.example11.service;


import com.spring.data.example11.dao.EmployeeDao;
import com.spring.data.example11.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void saveEmployeeWithoutTransaction() {
        System.out.println("Saving employee without transaction...");
        employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
    }

    @Transactional
    public void saveEmployeeInTransaction() {
        System.out.println("Saving employee with transaction...");
        employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
    }
}
