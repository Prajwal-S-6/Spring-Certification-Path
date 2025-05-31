package com.certification.spring.aop.example3.service.a;

import com.certification.spring.aop.example3.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Employee findEmployeeById(long id) {
        return new Employee();
    }

    @Override
    public void saveEmployee(Employee employee) {
    }

    @Override
    public void deleteEmployee(Employee employee) {
    }
}
