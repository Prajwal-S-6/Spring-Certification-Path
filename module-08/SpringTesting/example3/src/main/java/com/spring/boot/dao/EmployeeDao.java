package com.spring.boot.dao;


import com.spring.boot.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
