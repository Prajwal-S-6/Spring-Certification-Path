package com.certification.spring.aop.example5.repository;


import com.certification.spring.aop.example5.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {
    public Employee findEmployeeById(long id) {
        if (id == -1)
            throw new IllegalArgumentException("id cannot be -1");

        return new Employee(id);
    }

    public void saveEmployee(Employee employee) {
    }

    public void deleteEmployee(Employee employee) {
    }
}
