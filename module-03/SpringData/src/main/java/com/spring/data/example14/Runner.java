package com.spring.data.example14;

import com.spring.data.example14.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@ComponentScan
public class Runner {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.manualTransaction();
        employeeService.declarativeTransaction();
    }
}
