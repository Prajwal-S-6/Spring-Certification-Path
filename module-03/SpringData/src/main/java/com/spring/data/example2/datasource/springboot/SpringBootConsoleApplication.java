package com.spring.data.example2.datasource.springboot;

import com.spring.data.example2.datasource.springboot.service.EmployeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    EmployeeReportService employeeReportService;

    @Override
    public void run(String... args) throws Exception {
        employeeReportService.printReport();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }
}
