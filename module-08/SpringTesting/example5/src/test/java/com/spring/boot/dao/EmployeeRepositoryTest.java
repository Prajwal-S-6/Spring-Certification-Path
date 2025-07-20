package com.spring.boot.dao;

import com.spring.boot.entity.Employee;
import org.hsqldb.lib.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void shouldSaveEmployee() {
        Iterable<Employee> all = employeeRepository.findAll();
        System.out.println("Employees in DB: " + all);

        employeeRepository.save(new Employee(6, "John", "Doe", "John1.Doe@corp.com"));

        assertEquals(new Employee(6, "John", "Doe", "John1.Doe@corp.com").getEmail(),entityManager.find(Employee.class, 6).getEmail());
        // assertEquals(new Employee(7, "Dave", "Doyle", "Dave1.Doyle@corp.com").getEmail(), entityManager.find(Employee.class, 7).getEmail());
    }

    @Test
    public void shouldFindByEmail() {
        Employee e= new Employee(6, "John", "Doe", "John1.Doe@corp.com");
        entityManager.persist(e);

        Employee employee = employeeRepository.findByEmail("John1.Doe@corp.com");

        assertEquals(e.getEmail(), employee.getEmail());
    }
}