package com.spring.data.example26.dao;

import com.spring.data.example26.ds.Employee;
import com.spring.data.example26.ds.EmployeeKey;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, EmployeeKey> {

    Employee findByEmail(String email);
}
