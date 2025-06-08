package com.certification.spring.aop.example7;

import com.certification.spring.aop.example7.beans.*;
import com.certification.spring.aop.example7.ds.Department;
import com.certification.spring.aop.example7.ds.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();


        HelloChildBean helloChildBean = context.getBean(HelloChildBean.class);
        helloChildBean.sayHello("John", 5);
        helloChildBean.validateName("Jane");
        helloChildBean.saveCounterValue(7);
        helloChildBean.savePerson(new Person());
        helloChildBean.deletePerson(new Person());

        ITaxBean taxBean1 = (ITaxBean) context.getBean("taxBean1");
        taxBean1.calculateTax(1.2f);

        TaxBean2 taxBean2 = context.getBean(TaxBean2.class);
        taxBean2.calculateTax(5.5f);

        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        departmentRepository.findDepartment("IT");
        departmentRepository.updateDepartment(1, new Department());
        departmentRepository.getName();
        departmentRepository.getWorkPhone();

        EmployeeBean employeeBean = context.getBean(EmployeeBean.class);
        employeeBean.setId(1);
        employeeBean.setName("Praj");
        employeeBean.setCubicId("ABC");
        employeeBean.setWorkPhone("1234-56677");
        employeeBean.getId();
        employeeBean.getName();
        employeeBean.getCubicId();
        employeeBean.getWorkPhone();
    }
}
