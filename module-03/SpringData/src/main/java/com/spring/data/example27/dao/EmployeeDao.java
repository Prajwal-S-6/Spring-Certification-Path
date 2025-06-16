package com.spring.data.example27.dao;

import com.spring.data.example27.ds.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    List<Employee> findTop3ByOrderBySalaryDesc();

    Employee findByFirstNameAndLastName(String firstName, String lastName);

    Employee findByHireDateBetween(Date minData, Date maxDate);

    List<Employee> findByOrderByHireDateDesc();


}
