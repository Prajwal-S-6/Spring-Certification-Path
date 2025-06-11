package com.spring.data.example13;

import com.spring.data.example13.service.EmployeeServiceA;
import com.spring.data.example13.service.EmployeeServiceB;
import com.spring.data.example13.service.EmployeeServiceC;
import com.spring.data.example13.service.EmployeeServiceD;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ComponentScan
public class Runner {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeServiceA employeeServiceA = context.getBean(EmployeeServiceA.class);
        employeeServiceA.operationA();

        EmployeeServiceB employeeServiceB = context.getBean(EmployeeServiceB.class);
        employeeServiceB.operationB();

        EmployeeServiceC employeeServiceC = context.getBean(EmployeeServiceC.class);
        employeeServiceC.operationC();

        EmployeeServiceD employeeServiceD = context.getBean(EmployeeServiceD.class);
        employeeServiceD.operationD();

        EmployeeServiceE employeeServiceE  =context.getBean(EmployeeServiceE.class);
        employeeServiceE.operationEPackage();
        employeeServiceE.operationEProtected();
        Method operationEPrivate = EmployeeServiceE.class.getDeclaredMethod("operationEPrivate");
        operationEPrivate.setAccessible(true);
        operationEPrivate.invoke(employeeServiceE);
    }
}
