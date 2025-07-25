package com.spring.boot;


import com.spring.boot.dao.EmployeeRepository;
import com.spring.boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(String... args) {
        employeeRepository.saveAll(Arrays.asList(
                new Employee(1, "John", "Doe", "John.Doe@corp.com"),
                new Employee(2, "Dave", "Doyle", "Dave.Doyle@corp.com"),
                new Employee(3, "Tom", "Frost", "Tom.Frost@corp.com")
        ));

        employeeRepository.findAll().forEach(System.out::println);
    }
}
