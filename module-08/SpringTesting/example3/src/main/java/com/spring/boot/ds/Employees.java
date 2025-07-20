package com.spring.boot.ds;


import com.spring.boot.entity.Employee;

public class Employees {
    private Iterable<Employee> employees;

    @SuppressWarnings("unused")
    public Employees() {
    }

    public Employees(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public Iterable<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Iterable<Employee> employees) {
        this.employees = employees;
    }
}
