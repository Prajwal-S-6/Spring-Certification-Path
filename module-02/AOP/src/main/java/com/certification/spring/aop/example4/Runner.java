package com.certification.spring.aop.example4;

import com.certification.spring.aop.example4.service.b.AlternateEmployeeRepository;
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
        AlternateEmployeeRepository alternateEmployeeRepository = context.getBean(AlternateEmployeeRepository.class);

//        Employee employee = employeeRepository.findEmployeeById(1);
//        employeeRepository.deleteEmployee(employee);
//        employeeRepository.saveEmployee(employee);
        /// JDK dynamic proxy self-invocation is not supported - doesn't apply aspects for internal method(saveEmployee()) called from findAndUpdateEmployeeById()
        // employeeRepository.findAndUpdateEmployeeById(2, new Employee());

        /// deleteByEmail is not an interface method, hence JDK proxy will only proxy the methods implementing interface, hence it fails
//        Method deleteEmployee = employeeRepository.getClass().getDeclaredMethod("deleteByEmail", Employee.class);
//        deleteEmployee.setAccessible(true);
//        deleteEmployee.invoke(samePackageEmployeeRepository, "testuser@gamil.com");

//        Employee employee = alternateEmployeeRepository.findEmployeeById(1);
//        alternateEmployeeRepository.saveEmployee(employee);

        ///  deleteEmployee() is not proxied as it is final method, hence aspect is also not applied
        // alternateEmployeeRepository.deleteEmployee(employee);
        /// CGLIB proxy self-invocation is not supported -  doesn't apply aspects for internal method(saveEmployee()) called from findAndUpdateEmployeeById()
        // alternateEmployeeRepository.findAndUpdateEmployeeById(2, new Employee());

//        samePackageEmployeeRepository.saveEmployee(new Employee());
//        samePackageEmployeeRepository.deleteEmployee(4);
//        samePackageEmployeeRepository.deleteEmployeeByEmail("test@test.com");

        /// private methods are called from original class(SuperClass) but not proxied, hence aspects are not applied
        Method deleteEmployeeByPhone = samePackageEmployeeRepository.getClass().getSuperclass().getDeclaredMethod("deleteEmployeeByPhone", String.class);
        deleteEmployeeByPhone.setAccessible(true);
        deleteEmployeeByPhone.invoke(samePackageEmployeeRepository, "123-456-789");

    }
}
