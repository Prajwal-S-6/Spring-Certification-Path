package com.spring.data.example24.spring.boot.dao;

import com.spring.data.example24.spring.boot.ds.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
