package com.spring.data.example7.dao;

import com.spring.data.example7.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
    public String findEmployeeEmail(int id) {
        return jdbcTemplate.queryForObject("select email from employee where employee_id = ?", new Object[] {id}, String.class);
    }

    public List<String> findEmployeesNames() {
        return jdbcTemplate.queryForList("select first_name from employee", String.class);
    }

    public Map<String, Object> findEmployeeById(int id) {
        return jdbcTemplate.queryForMap("select * from employee where employee_id = ?", id);
    }

    public SqlRowSet findEmployeesRowSet() {
        return jdbcTemplate.queryForRowSet("select * from employee");
    }

    public Employee findEmployee(int id) {
        return jdbcTemplate.queryForObject("select * from employee where employee_id = ?", new Object[]{id}, this::mapEmployee);
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

    public List<Employee> findAllEmployees() {
       return jdbcTemplate.query("select * from employee", this::mapEmployee);
    }
}
