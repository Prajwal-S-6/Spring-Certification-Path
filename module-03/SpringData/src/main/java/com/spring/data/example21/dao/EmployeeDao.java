package com.spring.data.example21.dao;

import com.spring.data.example21.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// public interface EmployeeDao extends CrudRepository<Employee, Integer> {
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
