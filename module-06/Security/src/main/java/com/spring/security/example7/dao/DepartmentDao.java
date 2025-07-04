package com.spring.security.example7.dao;

import com.spring.security.example7.ds.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
