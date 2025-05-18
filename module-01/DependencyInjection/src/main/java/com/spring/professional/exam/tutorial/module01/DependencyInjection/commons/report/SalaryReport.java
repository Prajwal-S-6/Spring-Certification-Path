package com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.report;

import com.spring.professional.exam.tutorial.module01.DependencyInjection.commons.ds.EmployeeSalary;

import java.util.List;

public interface SalaryReport {
    void writeReport(List<EmployeeSalary> employeeSalaries);
}
