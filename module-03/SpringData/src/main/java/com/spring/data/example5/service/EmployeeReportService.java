package com.spring.data.example5.service;


import com.spring.data.example5.dao.EmployeeDao;
import com.spring.data.example5.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.spring.data.example5.utils.SqlRowSetUtil.SqlRowSetToString;


@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("findEmployees()");
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("findEmployeesEmails()");
        employeeDao.findEmployeesEmails()
                .forEach(System.out::println);

        System.out.println("findEmployeeWithHighestSalary()");
        System.out.println(employeeDao.findEmployeeWithHighestSalary());

        System.out.println("findEmployeeWithHighestSalarySQL()");
        System.out.println(employeeDao.findEmployeeWithHighestSalarySQL());

        System.out.println("findEmployeeThatWasHiredLast()");
        System.out.println(employeeDao.findEmployeeThatWasHiredLast());

        System.out.println("findEmployeesEmailsAndPhones()");
        System.out.println(SqlRowSetToString(employeeDao.findEmployeesEmailsAndPhones()));

        System.out.println("insertNewDummyRecord()");
        employeeDao.insertNewDummyRecord();
        System.out.println(employeeDao.findEmployeeById(6));

        try {
            System.out.println(employeeDao.findEmployeeById(666));
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("updateDummyRecord()");
        System.out.println("Result from update = " + employeeDao.updateDummyRecord(6, "UpdatedDummy"));
        System.out.println(employeeDao.findEmployeeById(6));

        System.out.println("updateRecordsWithDummyData()");
        System.out.println("Result from updateRecordsWithDummyData = " + Arrays.toString(employeeDao.updateRecordsWithDummyData()));
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("Employee Report Stop");
    }
}
