package com.spring.data.example5.dao;

import com.spring.data.example5.ds.Employee;
import com.spring.data.example5.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public Iterable<Employee> findEmployees() {
        return jdbcTemplate.query("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
                this::mapEmployee);
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

    public List<String> findEmployeesEmails() {
       return jdbcTemplate.queryForList("select email from employee", String.class);
    }

    public String findEmployeeWithHighestSalary() {
        return jdbcTemplate.query("select employee_id, first_name, last_name, salary from employee",
                new ResultSetExtractor<String>() {
                    @Override
                    public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                        float maxSalary = Integer.MIN_VALUE;
                        int employeeId = 0;
                        String firstName = "";
                        String lastName = "";
                        while(rs.next()) {
                            if(rs.getFloat("salary") > maxSalary) {
                                maxSalary = rs.getFloat("salary");
                                employeeId = rs.getInt("employee_id");
                                firstName = rs.getString("first_name");
                                lastName = rs.getString("last_name");
                            }
                        }

                        return String.format("Employee Id: %s, Name: %s %s, Salary: %s", employeeId, firstName, lastName, maxSalary);
                    }
                });
    }


    public Employee findEmployeeWithHighestSalarySQL() {
        return jdbcTemplate.queryForObject("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee order by salary desc limit 1", this::mapEmployee);
    }

    public Employee findEmployeeThatWasHiredLast() {
        return jdbcTemplate.queryForObject("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee order by hire_date desc limit 1", this::mapEmployee);
    }

    public SqlRowSet findEmployeesEmailsAndPhones() {
        return jdbcTemplate.queryForRowSet("select email, phone_number from employee");
    }

    public void insertNewDummyRecord() {
        jdbcTemplate.update("insert into employee values(6, 'Dummy', 'dummy', 'dummy@dummy.com', '1111-2222', '2025-06-09', 1)");
    }

    public Employee findEmployeeById(int id) {
        return jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareStatement("select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee where employee_id = ?");

            }
        }, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        }, new ResultSetExtractor<Employee>() {
            @Override
            public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    return new Employee(rs.getInt("employee_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getDate("hire_date"),
                            rs.getFloat("salary"));
                } else {
                    throw new EmployeeNotFoundException("No Employee found with id " + id);
                }

            }
        });
    }

    public int updateDummyRecord(int i, String updatedDummy) {
        return  jdbcTemplate.update("update employee set first_name = ? where employee_id = ?", updatedDummy, i);
    }

    public int[] updateRecordsWithDummyData() {
        return jdbcTemplate.batchUpdate(
                "update employee set first_name = 'AAA' where employee_id = 1",
                "update employee set first_name = 'BBB' where employee_id = 2",
                "update employee set first_name = 'CCC' where employee_id = 3"
        );
    }
}
