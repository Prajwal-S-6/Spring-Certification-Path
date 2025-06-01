package com.certification.spring.aop.example4.service.a;


import com.certification.spring.aop.example4.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public /*final*/ class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Employee findEmployeeById(long id) {
        return new Employee();
    }

    @Override
    public void saveEmployee(Employee employee) {
    }

    @Override
    public /*final*/ void deleteEmployee(Employee employee) {
    }

    @Override
    public void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        Employee employeeById = findEmployeeById(id);
        saveEmployee(employeeById);
    }

    public void deleteByEmail(String email) {

    }
}
