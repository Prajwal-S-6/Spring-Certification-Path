package com.spring.professional.exam.tutorial.commons.dao;

import com.spring.professional.exam.tutorial.commons.ds.Employee;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EmployeeDao {
    public List<Employee> findAll() {
        System.out.println("Finding all employees");
        return Collections.emptyList();
    }
}
