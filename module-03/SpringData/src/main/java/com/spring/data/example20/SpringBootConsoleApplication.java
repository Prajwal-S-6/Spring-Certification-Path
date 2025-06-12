package com.spring.data.example20;

import com.spring.data.example20.dao.EmployeeDao;
import com.spring.data.example20.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        try{
            employeeService.operationsWithAutoCommit();

        } catch (Exception e) {
            //
        }
        employeeService.findAllEmployees();
        employeeDao.deleteAllEmployees();
        System.out.println("\n\n");
        try {
            employeeService.operationsWithoutAutoCommit();
        } catch (Exception e) {
            //
        }
         employeeService.findAllEmployees();

    }
}
