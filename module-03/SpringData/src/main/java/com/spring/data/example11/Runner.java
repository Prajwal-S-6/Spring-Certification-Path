package com.spring.data.example11;

import com.spring.data.example11.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        try {
            employeeService.saveEmployeeWithoutTransaction();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        try {
            employeeService.saveEmployeeInTransaction();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
