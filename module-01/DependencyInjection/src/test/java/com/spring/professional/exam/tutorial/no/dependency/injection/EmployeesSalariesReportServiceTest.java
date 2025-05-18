package com.spring.professional.exam.tutorial.no.dependency.injection;

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

        // we cannot inject mocks for the dependencies as objects are directly used in the method

    }
}