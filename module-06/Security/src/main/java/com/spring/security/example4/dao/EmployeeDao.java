package com.spring.security.example4.dao;


import com.spring.security.example4.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
