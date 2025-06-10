package com.spring.data.example11.dao;

import com.spring.data.example11.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveEmployee(Employee employee) {
        if(employee.id() < 0) {
            throw new IllegalArgumentException("EmployeeId cannot be less than 0");
        }
        int numOfRecordsInserted = jdbcTemplate.update("insert into employee values(?, ?, ?, ?, ?, ?, ?)", employee.id(), employee.firstName(), employee.lastName(), employee.email(), employee.phoneNumber(), employee.hireDate(), employee.salary());
        if (numOfRecordsInserted == 1)
            System.out.println(String.format("Saved employee [%d]", employee.id()));
        else
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numOfRecordsInserted));
    }
}
