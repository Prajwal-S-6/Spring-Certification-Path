package com.spring.professional.exam.tutorial.manual.dependency.injection;

import com.spring.professional.exam.tutorial.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.commons.report.PdfSalaryReport;

public class Runner {
    public static void main(String... args) {
        EmployeesSalariesReportService employeesSalariesReportService = new EmployeesSalariesReportService(
                new EmployeeDao(),
                new EmployeeSalaryCalculator(),
                new PdfSalaryReport()
        );

        employeesSalariesReportService.generateReport();
    }
}
