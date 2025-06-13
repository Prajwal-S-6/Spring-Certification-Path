package com.spring.data.example26.dao;

import com.spring.data.example26.ds.Employee;
import com.spring.data.example26.ds.EmployeeKey;

public interface EmployeeDao extends CustomBaseRepository<Employee, EmployeeKey> {
}
