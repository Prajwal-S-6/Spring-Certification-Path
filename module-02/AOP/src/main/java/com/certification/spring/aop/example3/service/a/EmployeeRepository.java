package com.certification.spring.aop.example3.service.a;


import com.certification.spring.aop.example3.ds.Employee;

public interface EmployeeRepository {
    Employee findEmployeeById(long id);

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}
