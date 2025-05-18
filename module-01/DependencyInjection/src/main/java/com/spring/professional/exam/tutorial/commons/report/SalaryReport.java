package com.spring.professional.exam.tutorial.commons.report;

import com.spring.professional.exam.tutorial.commons.ds.EmployeeSalary;

import java.util.List;

public interface SalaryReport {
    void writeReport(List<EmployeeSalary> employeeSalaries);
}
