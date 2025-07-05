package com.spring.security.example8.dao;

import com.spring.security.example8.ds.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
