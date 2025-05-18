package com.spring.professional.exam.tutorial.no.dependency.injection;

public class Runner {
    public static void main(String... args) {
        EmployeesSalariesReportService employeesSalariesReportService = new EmployeesSalariesReportService();

        employeesSalariesReportService.generateReport();
    }
}
