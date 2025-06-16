package com.spring.data.example27.dao;

import com.spring.data.example27.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    List<Employee> findTop3ByOrderBySalaryDesc();

    Employee findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByHireDateBetween(Date minData, Date maxDate);

    List<Employee> findByOrderByHireDateDesc();

    Employee findFirstBySalaryLessThan(Float salary);


}
