package com.spring.data.example23.jpa.transaction.manager;

import com.spring.data.example23.jpa.transaction.manager.service.EmployeeProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeProductService employeeProductService = context.getBean(EmployeeProductService.class);
        try {
            employeeProductService.saveData();
        } catch (Exception e) {

        }
        employeeProductService.listAllData();
    }
}
