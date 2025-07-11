package com.spring.data.example4.jdbc.callback.service;

import com.spring.data.example4.jdbc.callback.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("Employees List");
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("Employees Average Salary Calculated Row by Row");
        System.out.println(employeeDao.findAverageSalaryRowByRow());
//
        System.out.println("Employees Average Salary Calculated on Entire Result Set");
        System.out.println(employeeDao.findAverageSalaryCalculatedOnEntireResultSet());
//
        System.out.println("Employees Average Salary with streams");
        System.out.println(employeeDao.findAverageSalaryCalculatedOnEntireResultSetUsingStream());
//
        System.out.println("Employees Average Salary sql level");
        System.out.println(employeeDao.findAverageSalarySqlLevel());
//
        System.out.println("Employee found based on email");
        System.out.println(employeeDao.findEmployeeIdFromEmail("Jayvon.Grant@corp.com"));

        System.out.println("Employee Report Stop");
    }
}
