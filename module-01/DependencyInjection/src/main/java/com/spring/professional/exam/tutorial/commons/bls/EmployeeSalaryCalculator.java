package com.spring.professional.exam.tutorial.commons.bls;

import com.spring.professional.exam.tutorial.commons.ds.Employee;
import com.spring.professional.exam.tutorial.commons.ds.EmployeeSalary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EmployeeSalaryCalculator {
    public List<EmployeeSalary> calculateSalaries(List<Employee> employees) {
        System.out.println("Calculating salaries");
        return Collections.emptyList();
    }
}
