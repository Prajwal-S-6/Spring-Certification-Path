package com.spring.data.example15.spring.proxy;

import com.spring.data.example15.spring.proxy.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.transaction1And2();
        employeeService.transaction1And2WithPrecedingTransaction();
    }
}
