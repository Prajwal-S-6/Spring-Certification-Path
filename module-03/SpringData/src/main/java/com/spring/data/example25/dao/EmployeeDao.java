package com.spring.data.example25.dao;

import com.spring.data.example25.ds.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    Employee findByEmail(String email);

    List<Employee> findBySalaryBetween(float maxSalary, float minSalary);

    Employee findByLastName(String lastName);
}
