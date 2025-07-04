package com.spring.security.example6.dao;

import com.spring.security.example6.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesDao extends CrudRepository<Employee, Integer> {
}
