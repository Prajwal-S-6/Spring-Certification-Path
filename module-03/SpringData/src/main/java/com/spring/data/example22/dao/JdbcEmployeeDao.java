package com.spring.data.example22.dao;

import com.spring.data.example22.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcEmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void save(Employee employee) {
        jdbcTemplate.update( "insert into employee(id, firstName, lastName, email, phoneNumber, hireDate, salary)" +
                        "values (?, ?, ?, ?, ?, ?, ?)",
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getSalary());
    }
}
