package com.certification.spring.aop.example4;

import com.certification.spring.aop.example4.ds.Employee;
import com.certification.spring.aop.example4.service.a.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
//        Employee employee = employeeRepository.findEmployeeById(1);
//        employeeRepository.deleteEmployee(employee);
//        employeeRepository.saveEmployee(employee);
        /// doesn't apply aspects for internal method(saveEmployee()) called from findAndUpdateEmployeeById()
        employeeRepository.findAndUpdateEmployeeById(2, new Employee());
    }
}
