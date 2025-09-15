package com.spring.data.example3.jdbc.template.service;


import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;



@SpringBootTest()
@Import(TestDataSourceConfig.class)
@ExtendWith(OutputCaptureExtension.class)
@ActiveProfiles("test")
class EmployeeReportServiceTest {

    @Autowired
    private EmployeeReportService employeeReportService;


    @BeforeAll
    static void beforeAll() {
        System.out.close();
    }

    @Test
    void shouldPrintReport(CapturedOutput capturedOutput) {
        employeeReportService.printReport();
        Approvals.verify(capturedOutput.getOut());
    }
}