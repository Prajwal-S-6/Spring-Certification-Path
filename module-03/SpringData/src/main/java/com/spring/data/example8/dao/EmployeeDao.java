package com.spring.data.example8.dao;

import com.spring.data.example8.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findAllEmployees() {
        return jdbcTemplate.query("select * from employee", this::mapEmployee);
    }

    private Employee mapEmployee(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getInt("employee_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getDate("hire_date"),
                rs.getFloat("salary"));
    }

    public void deleteAllEmployees() {
        int numberOfDeletedRows = jdbcTemplate.update("delete from employee");
        System.out.println(String.format("Employees deleted, number of deleted rows = [%d]", numberOfDeletedRows));

    }

    public void saveEmployee(Employee employee) {
        int numOfRecordsInserted = jdbcTemplate.update("insert into employee values(?, ?, ?, ?, ?, ?, ?)", employee.id(), employee.firstName(), employee.lastName(), employee.email(), employee.phoneNumber(), employee.hireDate(), employee.salary());
        if (numOfRecordsInserted == 1)
            System.out.println(String.format("Saved employee [%d]", employee.id()));
        else
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numOfRecordsInserted));
    }
}
