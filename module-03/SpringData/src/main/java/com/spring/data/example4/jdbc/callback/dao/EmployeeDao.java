package com.spring.data.example4.jdbc.callback.dao;

import com.spring.data.example4.jdbc.callback.ds.Employee;
import com.spring.data.example4.jdbc.callback.impl.CustomResultSetExtractor;
import com.spring.data.example4.jdbc.callback.impl.CustomRowCallBackHandler;
import com.spring.data.example4.jdbc.callback.impl.CustomRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public Float findAverageSalarySqlLevel() {
        return jdbcTemplate.queryForObject("select avg(salary) from employee", Float.class);
    }

    public Integer findEmployeeIdFromEmail(String mail) {

        return jdbcTemplate.query(new PreparedStatementCreator() {
                                      @Override
                                      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                          return con.prepareStatement("select employee_id from employee where email = ?");
                                      }
                                  },
                new PreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, mail);
                    }
                },
                new ResultSetExtractor<Integer>() {
                    @Override
                    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if(rs.next()) {
                            return rs.getInt("employee_id");
                        } else {
                            throw new SQLException("No Employee found with the email " + mail);
                        }
                    }
                }
                );
    }
}
