package com.certification.spring.aop.example4;

import com.certification.spring.aop.example4.service.a.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        employeeRepository.findEmployeeById(1);
    }
}
