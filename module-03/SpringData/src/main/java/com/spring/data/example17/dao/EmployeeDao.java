package com.spring.data.example17.dao;

import com.spring.data.example17.ds.Employee;
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

    public List<Employee> findAllEmployeesByIdRange(int minId, int maxId) {
        return jdbcTemplate.query(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary " +
                        "from employee " +
                        "where employee_id between ? and ?",
                new Object[]{minId, maxId},
                this::mapEmployee
        );
    }

    public void saveEmployee(Employee employee) {
        int numberOfRecordsInserted = jdbcTemplate.update(
                "insert into employee(employee_id, first_name, last_name, email, phone_number, hire_date, salary) " +
                        "values (?, ?, ?, ?, ?, ?, ?)",
                employee.id(),
                employee.firstName(),
                employee.lastName(),
                employee.email(),
                employee.phoneNumber(),
                employee.hireDate(),
                employee.salary()
        );

        if (numberOfRecordsInserted == 1)
            System.out.println(String.format("Saved employee [%d]", employee.id()));
        else
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numberOfRecordsInserted));
    }

    public void maskEmail(int id) {
        int numberOfUpdatesRows = jdbcTemplate.update(
                "update employee set email='XXX.XXX@XXX.XXX' where employee_id = ?",
                id
        );

        if (numberOfUpdatesRows == 1)
            System.out.println(String.format("Updated employee email [%d]", id));
        else
            throw new IllegalStateException(String.format("Expected 1 record to be updated, instead updated [%d] number of records inserted", numberOfUpdatesRows));
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
