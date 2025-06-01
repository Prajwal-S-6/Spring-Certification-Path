package com.certification.spring.aop.example4.service.a;


import com.certification.spring.aop.example4.ds.Employee;

public interface EmployeeRepository {
    Employee findEmployeeById(long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    void findAndUpdateEmployeeById(long id, Employee employeeToMerge);
}
