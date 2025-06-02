package com.certification.spring.aop.example5;

import com.certification.spring.aop.example5.ds.Employee;
import com.certification.spring.aop.example5.repository.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        employeeRepository.findEmployeeById(1);
        employeeRepository.saveEmployee(new Employee(2));
        employeeRepository.deleteEmployee(new Employee(3));
    }
}
