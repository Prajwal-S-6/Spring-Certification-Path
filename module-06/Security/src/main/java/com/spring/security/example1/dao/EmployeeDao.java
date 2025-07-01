package com.spring.security.example1.dao;

import com.spring.security.example1.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
