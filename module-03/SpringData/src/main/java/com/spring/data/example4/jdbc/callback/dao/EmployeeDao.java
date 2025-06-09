package com.spring.data.example4.jdbc.callback.dao;

import com.spring.data.example4.jdbc.callback.ds.Employee;
import com.spring.data.example4.jdbc.callback.impl.CustomResultSetExtractor;
import com.spring.data.example4.jdbc.callback.impl.CustomRowCallBackHandler;
import com.spring.data.example4.jdbc.callback.impl.CustomRowMapper;
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

    public EmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findEmployees() {
        /// implementing jdbc template callback using anonymous class
//        return jdbcTemplate.query("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
//                new RowMapper<Employee>() {
//                    @Override
//                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        return new Employee(rs.getInt("employee_id"),
//                                rs.getString("first_name"),
//                                rs.getString("last_name"),
//                                rs.getString("email"),
//                                rs.getString("phone_number"),
//                                rs.getDate("hire_date"),
//                                rs.getFloat("salary"));
//                    }
//                });

        /// implementing RowMapper interface
        // return jdbcTemplate.query("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee", new CustomRowMapper());

        /// implementing RowMapper interface callback using lambda expression
        return jdbcTemplate.query("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
                (ResultSet rs, int rowNum) -> {
                    return new Employee(rs.getInt("employee_id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email"),
                                rs.getString("phone_number"),
                                rs.getDate("hire_date"),
                                rs.getFloat("salary"));
                });
    }


    public float findAverageSalaryRowByRow() {
        CustomRowCallBackHandler customRowCallBackHandler = new CustomRowCallBackHandler();
        jdbcTemplate.query("select salary from employee", customRowCallBackHandler);
        return customRowCallBackHandler.getAverageSalary();
    }

    public Float findAverageSalaryCalculatedOnEntireResultSet() {
        CustomResultSetExtractor customResultSetExtractor = new CustomResultSetExtractor();
        return (Float) jdbcTemplate.query("SELECT SALARY FROM EMPLOYEE", customResultSetExtractor);
    }

    /// using stream
    public double findAverageSalaryCalculatedOnEntireResultSetUsingStream() {
        return jdbcTemplate.queryForList("select salary from employee", Double.class)
                .stream()
                .mapToDouble(Double::valueOf)
                .average()
                .orElse(0f);
    }

    public float findAverageSalarySqlLevel() {
        return jdbcTemplate.queryForObject("select avg(salary) from employee", Float.class);
    }
}
