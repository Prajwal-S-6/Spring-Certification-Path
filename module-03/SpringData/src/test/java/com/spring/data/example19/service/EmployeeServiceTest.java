package com.spring.data.example19.service;

import com.spring.data.example19.Runner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Runner.class)
class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    @Transactional
    public void shouldRollbackTheTransaction() {
        employeeService.methodWithTransaction();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void shouldNotRollbackTheTransaction() {
        employeeService.methodWithTransaction();
    }

}