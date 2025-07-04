package com.spring.security.example7.dao;


import com.spring.security.example7.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
