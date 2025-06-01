package com.certification.spring.aop.example4;

import com.certification.spring.aop.example4.ds.Employee;
import com.certification.spring.aop.example4.service.a.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        SamePackageEmployeeRepository samePackageEmployeeRepository = context.getBean(SamePackageEmployeeRepository.class);
//        Employee employee = employeeRepository.findEmployeeById(1);
//        employeeRepository.deleteEmployee(employee);
//        employeeRepository.saveEmployee(employee);
        /// doesn't apply aspects for internal method(saveEmployee()) called from findAndUpdateEmployeeById()
        employeeRepository.findAndUpdateEmployeeById(2, new Employee());

        /// deleteByEmail is not an interface method, hence JDK proxy will only proxy the methods implementing interface, hence it fails
//        Method deleteEmployee = employeeRepository.getClass().getDeclaredMethod("deleteByEmail", Employee.class);
//        deleteEmployee.setAccessible(true);
//        deleteEmployee.invoke(samePackageEmployeeRepository, "testuser@gamil.com");

    }
}
