package com.certification.spring.aop.example3;

import com.certification.spring.aop.example3.ds.Employee;
import com.certification.spring.aop.example3.service.a.EmployeeRepository;
import com.certification.spring.aop.example3.service.b.AlternateEmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        //AlternateEmployeeRepository employeeRepository = context.getBean(AlternateEmployeeRepository.class);

        Employee employee = employeeRepository.findEmployeeById(1);
        employeeRepository.saveEmployee(employee);
        employeeRepository.deleteEmployee(employee);
    }
}
