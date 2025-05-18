package com.spring.professional.exam.tutorial.no.dependency.injection;

import com.spring.professional.exam.tutorial.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.commons.ds.Employee;
import com.spring.professional.exam.tutorial.commons.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.commons.report.PdfSalaryReport;

import java.util.List;

class EmployeesSalariesReportService {
    void generateReport() {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();

        EmployeeSalaryCalculator employeeSalaryCalculator = new EmployeeSalaryCalculator();
        List<EmployeeSalary> employeeSalaries = employeeSalaryCalculator.calculateSalaries(employees);

        PdfSalaryReport pdfSalaryReport = new PdfSalaryReport();
        pdfSalaryReport.writeReport(employeeSalaries);
    }
}
