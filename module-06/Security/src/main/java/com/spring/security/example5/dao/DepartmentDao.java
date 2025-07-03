package com.spring.security.example5.dao;

import com.spring.security.example4.ds.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
