package com.spring.professional.exam.tutorial.module01.DependencyInjection.manual.dependency.injection;

import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.report.XlsSalaryReport;

public class Runner {
    public static void main(String... args) {
//        EmployeesSalariesReportService employeesSalariesReportService = new EmployeesSalariesReportService(
//                new EmployeeDao(),
//                new EmployeeSalaryCalculator(),
//                new PdfSalaryReport()
//        );

        EmployeesSalariesReportService employeesSalariesReportService = new EmployeesSalariesReportService(
                new EmployeeDao(),
                new EmployeeSalaryCalculator(),
                new XlsSalaryReport()
        );
        employeesSalariesReportService.generateReport();
    }
}
