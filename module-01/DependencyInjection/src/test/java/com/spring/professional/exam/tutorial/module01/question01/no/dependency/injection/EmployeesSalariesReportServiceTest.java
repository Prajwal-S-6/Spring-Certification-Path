package com.spring.professional.exam.tutorial.module01.question01.no.dependency.injection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeesSalariesReportServiceTest {

    @InjectMocks
    private EmployeesSalariesReportService employeesSalariesReportService;

    @Test
    public void shouldGenerateSalaryReport() {

        // we cannot test this as the dependencies are directly coupled, and we cannot inject any mocks for this dependency

    }
}