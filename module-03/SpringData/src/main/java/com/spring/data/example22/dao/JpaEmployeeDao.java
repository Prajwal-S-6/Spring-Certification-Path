package com.spring.data.example22.dao;

import com.spring.data.example22.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEmployeeDao extends JpaRepository<Employee, Integer> {
}
