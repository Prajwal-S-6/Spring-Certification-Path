package com.certification.spring.preparation.dao;


import com.certification.spring.preparation.ds.Department;

public class DepartmentDao {
    public Department findById(int id) {
        System.out.println("Searching for department...");
        return new Department();
    }

    public void save(Department department) {
        System.out.println("Saving department...");
    }
}
