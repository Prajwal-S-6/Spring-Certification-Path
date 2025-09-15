package com.spring.data.example8.service;


import ch.qos.logback.classic.Logger;
import com.spring.data.example8.dao.EmployeeDao;
import com.spring.data.example8.ds.Employee;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeesService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(EmployeesService.class);
    @Autowired
    private EmployeeDao employeeDao;

    Logger logger = (Logger) LoggerFactory.getLogger(EmployeesService.class);

    public void printEmployees() {
        logger.info("Printing list of employees");
        employeeDao.findAllEmployees().forEach(employee -> logger.info(employee.toString()));
    }

    public void deleteAllEmployees() {
        logger.info("Deleting all employees...");
        employeeDao.deleteAllEmployees();
    }

    public void saveEmployeesWithoutTransaction() {
        logger.info("Saving employees without transaction...");
        saveEmployees();
    }

    @Transactional
    public void saveEmployeesInTransaction() {
        logger.info("Saving employees with transaction...");
        saveEmployees();
    }

    private void saveEmployees() {
        employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        employeeDao.saveEmployee(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
        employeeDao.saveEmployee(new Employee(3, "Jayvon", "Grant", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
        employeeDao.saveEmployee(new Employee(-1, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
        employeeDao.saveEmployee(new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));
    }
}
