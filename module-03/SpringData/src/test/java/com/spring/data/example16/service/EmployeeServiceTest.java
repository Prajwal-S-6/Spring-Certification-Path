package com.spring.data.example16.service;

import com.spring.data.example16.configuration.DataSourceConfig;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({OutputCaptureExtension.class, SpringExtension.class})
@ContextConfiguration(classes = DataSourceConfig.class)
class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    // testing by checking that transaction/connection is created after
    @Test
    void shouldCreateOneNewConnectionWhenCalledWithTransactionalRequiredAndNoTransactionExists(CapturedOutput capturedOutput) {
        employeeService.callRequiredWithoutCurrentTransaction();
        List<String> output= capturedOutput.getOut().lines().toList();
        int index1 = output.indexOf("Starting callRequiredWithoutCurrentTransaction");
        int index2 = output.indexOf("Data Source Trace: Connection javax.sql.DataSource.getConnection()");
        assertThat(index1).isLessThan(index2);
    }


    // testing by checking that transaction/connection is not created after; instead resused
    @Test
    void shouldUseConnectionWhenCalledWithTransactionalRequiredAndTransactionExists(CapturedOutput capturedOutput) {
        employeeService.callRequiredWithCurrentTransaction();
        List<String> output= capturedOutput.getOut().lines().toList();
        int index1 = output.indexOf("Starting callRequiredWithCurrentTransaction");
        int index2 = output.indexOf("Data Source Trace: Connection javax.sql.DataSource.getConnection()");
        assertThat(index2).isLessThan(index1);
    }

    // testing by checking that existing transaction/connection is supported
    @Test
    void shouldUseConnectionWhenCalledWithTransactionalSupportsAndTransactionExists(CapturedOutput capturedOutput) {
        employeeService.callSupportsWithCurrentTransaction();
        List<String> output= capturedOutput.getOut().lines().toList();
        int index1 = output.indexOf("Starting callSupportsWithCurrentTransaction");
        int index2 = output.indexOf("Data Source Trace: Connection javax.sql.DataSource.getConnection()");
        assertThat(index2).isLessThan(index1);
    }


    // testing by checking that it doesnt create connection/transaction
    @Test
    void shouldNotCreateConnectionWhenCalledWithTransactionalSupportsAndNoTransactionExists(CapturedOutput capturedOutput) {
        employeeService.callSupportsWithoutCurrentTransaction();
        List<String> output= capturedOutput.getOut().lines().toList();
        assertThat(output).doesNotContain("Data Source Trace: Connection javax.sql.DataSource.getConnection()");
    }

    // testing by checking that it reuses existing transaction when exists
    @Test
    void shouldUseConnectionWhenCalledWithTransactionalMandatoryAndTransactionExists(CapturedOutput capturedOutput) {
        employeeService.callMandatoryWithCurrentTransaction();
        List<String> output= capturedOutput.getOut().lines().toList();
        int index1 = output.indexOf("Starting callMandatoryWithCurrentTransaction");
        int index2 = output.indexOf("Data Source Trace: Connection javax.sql.DataSource.getConnection()");
        assertThat(index2).isLessThan(index1);
    }



}