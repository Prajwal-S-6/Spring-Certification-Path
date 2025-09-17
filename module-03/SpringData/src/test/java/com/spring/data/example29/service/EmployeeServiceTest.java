package com.spring.data.example29.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.spring.data.example29.dao.EmployeeDao;
import com.spring.data.example29.ds.Employee;
import org.approvaltests.Approvals;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDao employeeDao;

    ObjectMapper objectMapper;
    ObjectWriter writer;

    @BeforeEach
    void setUp() {

        objectMapper = new ObjectMapper();
        writer = objectMapper.writerWithDefaultPrettyPrinter();
    }

    @Test
    void shouldSaveAllEmployees() throws JsonProcessingException {

        employeeService.saveAllEmployees();

        List<Employee> employeeList = employeeDao.findAll();

        assertThat(employeeList.size()).isEqualTo(5);
        Approvals.verify(writer.writeValueAsString(employeeList));
    }

    @Test
    void shouldQueryWillowZhangEmployee() {
        Employee employee = employeeService.queryEmployee();

        assertThat(employee.getFirstName()).isEqualTo("Willow");
        assertThat(employee.getLastName()).isEqualTo("Zhang");
    }
}