package com.certification.spring.aop.example3.service.b;


import com.certification.spring.aop.example3.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class AlternateEmployeeRepository {
    public Employee findEmployeeById(long id) {
        return new Employee();
    }

    public void saveEmployee(Employee employee) {
    }

    public void deleteEmployee(Employee employee) {
    }
}
