package com.spring.data.example24.spring.framework.dao;

import com.spring.data.example24.spring.framework.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
