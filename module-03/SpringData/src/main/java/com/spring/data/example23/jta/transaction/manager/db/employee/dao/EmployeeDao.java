package com.spring.data.example23.jta.transaction.manager.db.employee.dao;

import com.spring.data.example23.jta.transaction.manager.db.employee.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
