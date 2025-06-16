package com.spring.data.example29.dao;

import com.spring.data.example29.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.lastName = ?2 and e.firstName = ?1")
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
