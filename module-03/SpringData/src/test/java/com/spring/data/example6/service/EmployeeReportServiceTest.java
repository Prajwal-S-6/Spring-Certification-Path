package com.spring.data.example6.service;


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
    void shouldCreateNewConnectionForEachMethod(CapturedOutput capturedOutput) {
        employeeReportService.printReport();
        Approvals.verify(capturedOutput.getOut().lines().filter(string -> string.contains("getConnection")).reduce((val1, val2) -> val1 + "\n" + val2).get());
    }

    @Test
    void shouldCreateOneConnectionForAllMethods(CapturedOutput capturedOutput) {
        employeeReportService.printReportInTransaction();
        Approvals.verify(capturedOutput.getOut().lines().filter(string -> string.contains("getConnection")).reduce((val1, val2) -> val1 + "\n" + val2).get());
    }
}