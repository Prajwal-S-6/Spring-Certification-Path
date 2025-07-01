package com.spring.security.example1.dao;

import com.spring.security.example1.ds.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
