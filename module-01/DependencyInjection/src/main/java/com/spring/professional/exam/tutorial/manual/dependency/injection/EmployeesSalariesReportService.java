package com.spring.professional.exam.tutorial.manual.dependency.injection;

import com.spring.professional.exam.tutorial.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.commons.ds.Employee;
import com.spring.professional.exam.tutorial.commons.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.commons.report.SalaryReport;

import java.util.List;

class EmployeesSalariesReportService {
    private final EmployeeDao employeeDao;
    private final EmployeeSalaryCalculator employeeSalaryCalculator;
    private final SalaryReport salaryReport;

    EmployeesSalariesReportService(EmployeeDao employeeDao, EmployeeSalaryCalculator employeeSalaryCalculator, SalaryReport salaryReport) {
        this.employeeDao = employeeDao;
        this.employeeSalaryCalculator = employeeSalaryCalculator;
        this.salaryReport = salaryReport;
    }

    void generateReport() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeSalary> employeeSalaries = employeeSalaryCalculator.calculateSalaries(employees);

        salaryReport.writeReport(employeeSalaries);
    }
}
