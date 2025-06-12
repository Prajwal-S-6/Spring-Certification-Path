package com.spring.data.example20.dao;

import com.spring.data.example20.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    public List<Employee> findAllEmployees() {
        return jdbcTemplate.query("select * from employee", this::mapEmployee);
    }

    private Employee mapEmployee(ResultSet resultSet, int rowNum) throws SQLException {
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

    public void saveEmployee(Employee employee) {
        if(employee.id() < 0) {
            throw  new IllegalArgumentException("Employee id cannot be less than or equal to zero");
        }

        int numOfRecordsInserted = jdbcTemplate.update("insert into employee values(?,?,?,?,?,?,?)",
                employee.id(),
                employee.firstName(),
                employee.lastName(),
                employee.email(),
                employee.phoneNumber(),
                employee.hireDate(),
                employee.salary());
        if (numOfRecordsInserted == 1)
            System.out.println(String.format("Saved employee [%d]", employee.id()));
        else
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numOfRecordsInserted));
    }

    public void deleteAllEmployees() {
        int numOfRowsDeleted = jdbcTemplate.update("delete from employee");
        System.out.println(String.format("Employees deleted, number of deleted rows = [%d]", numOfRowsDeleted));
    }
}
