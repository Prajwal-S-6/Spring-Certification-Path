package com.spring.data.example28.dao.regular;

import com.spring.data.example28.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
