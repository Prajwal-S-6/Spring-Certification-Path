package com.spring.boot;

import com.spring.boot.configuration.filestore.FileStore;
import com.spring.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private FileStore fileStore;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.printEmployeeEmails();

        System.out.println("=================================================");

        fileStore.print();
    }
}