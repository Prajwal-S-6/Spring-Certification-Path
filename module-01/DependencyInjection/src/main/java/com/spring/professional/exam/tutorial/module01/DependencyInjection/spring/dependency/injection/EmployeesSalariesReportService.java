package com.spring.professional.exam.tutorial.module01.DependencyInjection.spring.dependency.injection;

import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.ds.Employee;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.report.SalaryReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
