package com.spring.data.example12;

import com.spring.data.example12.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        try {
            employeeService.saveEmployeesWithoutTransaction();
        } catch (IllegalArgumentException e) {
            System.out.println("Without transaction" + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployees();

        try {
            employeeService.saveEmployeesInTransaction();
        } catch (IllegalArgumentException e) {
            System.out.println("In transaction" + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployees();
    }
}
