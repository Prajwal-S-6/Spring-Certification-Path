package com.spring.security.example8.dao;


import com.spring.security.example8.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
