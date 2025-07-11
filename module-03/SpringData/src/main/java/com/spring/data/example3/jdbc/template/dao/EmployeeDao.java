package com.spring.data.example3.jdbc.template.dao;

import com.spring.data.example3.jdbc.template.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findEmployees() {
        return jdbcTemplate.query(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
                this::mapEmployee
        );
    }

    public Employee findFirstHiredEmployee() {
        return jdbcTemplate.queryForObject(
                "select * from employee order by hire_date limit 1",
                this::mapEmployee
        );
    }

    public Employee findEmployeeWithHighestSalary() {
        return jdbcTemplate.queryForObject(
                "select * from employee order by salary desc limit 1",
                this::mapEmployee
        );
    }

    public Integer findEmployeesCount() {
        return jdbcTemplate.queryForObject(
                "select count(*) from employee",
                Integer.class
        );
    }

    private Employee mapEmployee(ResultSet resultSet, int i) throws SQLException {
        return new Employee(
                resultSet.getInt("employee_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getDate("hire_date"),
                resultSet.getFloat("salary")
        );
    }
}
