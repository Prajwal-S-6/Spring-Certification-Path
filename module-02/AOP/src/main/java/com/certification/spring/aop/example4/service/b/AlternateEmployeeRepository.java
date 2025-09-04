package com.certification.spring.aop.example4.service.b;


import com.certification.spring.aop.example4.ds.Employee;
import org.springframework.stereotype.Component;

@Component
public class AlternateEmployeeRepository {
    public final Employee findEmployeeById(long id) {
        return new Employee();
    }

    public final void saveEmployee(Employee employee) {
    }

    public final void deleteEmployee(Employee employee) {
    }

    public final void findAndUpdateEmployeeById(long id, Employee employeeToMerge) {
        Employee employeeById = findEmployeeById(id);
        saveEmployee(employeeById);
    }
}
