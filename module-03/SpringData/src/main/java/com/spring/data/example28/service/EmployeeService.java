package com.spring.data.example28.service;

import com.spring.data.example28.dao.custom.respository.CustomEmployeeDao;
import com.spring.data.example28.ds.Employee;
import com.spring.data.example28.dao.regular.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CustomEmployeeDao customEmployeeDao;

    public void saveAllEmployees() {
        System.out.println("Saving all employees...");

        employeeDao.save(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        employeeDao.save(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
        employeeDao.save(new Employee(3, "Jayvon", "Krueger", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
        employeeDao.save(new Employee(4, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
        employeeDao.save(new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));

        System.out.println("Saved all employees");
    }

    public void queryEmployee() {
        System.out.println("Searching for John Doe employee with SimpleJpa implementation...");
        System.out.println(
                employeeDao.findByFirstNameAndLastName("John", "Doe")
        );

        System.out.println("Searching for John Doe employee with custom dao implementation...");
        System.out.println(
                customEmployeeDao.findByFirstNameAndLastName("John", "Doe")
        );
    }
}
