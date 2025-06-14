package com.spring.data.example7.service;

import com.spring.data.example7.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.spring.data.example7.utills.SqlRowSetUtil.SqlRowSetToString;


@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("findEmployeeEmail(1)");
        System.out.println(employeeDao.findEmployeeEmail(1));

        System.out.println("findEmployeesNames()");
        employeeDao.findEmployeesNames().forEach(System.out::println);

        System.out.println("findEmployeeById(2)");
        System.out.println(employeeDao.findEmployeeById(1));

        System.out.println("findEmployeesRowSet()");
        System.out.println(SqlRowSetToString(employeeDao.findEmployeesRowSet()));

        System.out.println("findEmployee(3)");
        System.out.println(employeeDao.findEmployee(2));

        System.out.println("findAllEmployees()");
        employeeDao.findAllEmployees().forEach(System.out::println);

        System.out.println("Employee Report Stop");
    }

}
