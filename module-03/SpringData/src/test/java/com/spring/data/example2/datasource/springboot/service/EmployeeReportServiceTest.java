package com.spring.data.example2.datasource.springboot.service;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;




@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class EmployeeReportServiceTest {

    @Autowired
    private EmployeeReportService employeeReportService;
    

    @BeforeAll
    static void setUp() {
        System.out.close();
    }

    @Test
    void shouldPrintListOfEmployees(CapturedOutput capturedOutput) {
        employeeReportService.printReport();
        Approvals.verify(capturedOutput.getOut());
    }

}