package com.spring.data.example3.jdbc.template.service;


import com.spring.data.example3.jdbc.template.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("Employee Count = " + employeeDao.findEmployeesCount());
        System.out.println("First Hired Employee Count = " + employeeDao.findFirstHiredEmployee());
        System.out.println("Highest Salary Employee Count = " + employeeDao.findEmployeeWithHighestSalary());

        System.out.println("Employees List");
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("Employee Report Stop");
    }
}
