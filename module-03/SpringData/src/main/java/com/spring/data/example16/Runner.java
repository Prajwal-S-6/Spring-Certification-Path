package com.spring.data.example16;

import com.spring.data.example16.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        System.out.println("-----------------------------------------------------------------");


        employeeService.callRequiredWithoutCurrentTransaction();
        System.out.println("\n");
        employeeService.callRequiredWithCurrentTransaction();

        System.out.println("-----------------------------------------------------------------");

        employeeService.callSupportsWithoutCurrentTransaction();
        System.out.println("\n");
        employeeService.callSupportsWithCurrentTransaction();

        System.out.println("-----------------------------------------------------------------");

        employeeService.callMandatoryWithoutCurrentTransaction();
        System.out.println("\n");
        employeeService.callMandatoryWithCurrentTransaction();

        System.out.println("-----------------------------------------------------------------");

        employeeService.callRequiresNewWithoutCurrentTransaction();
        System.out.println("\n");
        employeeService.callRequiresNewWithCurrentTransaction();

        System.out.println("-----------------------------------------------------------------");

        employeeService.callNotSupportedWithoutCurrentTransaction();
        System.out.println("\n");
        employeeService.callNotSupportedWithCurrentTransaction();

        System.out.println("-----------------------------------------------------------------");

        employeeService.callNeverWithoutCurrentTransaction();
        System.out.println("\n");
        employeeService.callNeverWithCurrentTransaction();

        System.out.println("-----------------------------------------------------------------");

        employeeService.callNestedWithoutCurrentTransaction();
        System.out.println("\n");
        employeeService.callNestedWithCurrentTransaction();
        System.out.println("-----------------------------------------------------------------");

    }
}
