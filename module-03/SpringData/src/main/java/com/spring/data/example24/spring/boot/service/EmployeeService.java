package com.spring.data.example24.spring.boot.service;

import com.spring.data.example24.spring.boot.dao.EmployeeDao;
import com.spring.data.example24.spring.boot.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void saveAllEmployees() {
        System.out.println("Saving all employees...");

        employeeDao.save(new Employee(1, "John2", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        employeeDao.save(new Employee(2, "Willow2", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
        employeeDao.save(new Employee(3, "Jayvon2", "Grant", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
        employeeDao.save(new Employee(4, "Shaylee2", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
        employeeDao.save(new Employee(5, "Miley2", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));

        System.out.println("Saved all employees");
    }

    public void listAllEmployees() {
        System.out.println("Listing all employees...");

        employeeDao.findAll().forEach(System.out::println);
    }
}
