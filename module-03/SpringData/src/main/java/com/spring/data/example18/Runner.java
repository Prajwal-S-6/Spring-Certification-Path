package com.spring.data.example18;

import com.spring.data.example18.exceptions.CustomCheckedException;
import com.spring.data.example18.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class Runner {

    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        try {
            employeeService.methodWithUncheckedExceptionCausingRollback();
        } catch (Exception e) {
            System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
        }

        try {
            employeeService.methodWithCheckedExceptionNotCausingRollback();
        } catch (Exception e) {
            System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
        }

        try {
            employeeService.methodWithUncheckedExceptionNotCausingRollback();
        } catch (Exception e) {
            System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
        }

        try {
            employeeService.methodWithCheckedExceptionCausingRollback();
        } catch (Exception e) {
            System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
        }

    }
}
