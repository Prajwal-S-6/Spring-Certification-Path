package com.spring.security.example6.dao;

import com.spring.security.example6.ds.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
