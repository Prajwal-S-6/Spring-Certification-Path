package com.spring.professional.exam.tutorial.module01.DependencyInjection.no.dependency.injection;

import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.ds.Employee;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.report.XlsSalaryReport;

import java.util.List;

class EmployeesSalariesReportService {
    void generateReport() {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();

        EmployeeSalaryCalculator employeeSalaryCalculator = new EmployeeSalaryCalculator();
        List<EmployeeSalary> employeeSalaries = employeeSalaryCalculator.calculateSalaries(employees);

//        PdfSalaryReport pdfSalaryReport = new PdfSalaryReport();
//        pdfSalaryReport.writeReport(employeeSalaries);

        XlsSalaryReport xlsSalaryReport = new XlsSalaryReport();
        xlsSalaryReport.writeReport(employeeSalaries);
    }
}
