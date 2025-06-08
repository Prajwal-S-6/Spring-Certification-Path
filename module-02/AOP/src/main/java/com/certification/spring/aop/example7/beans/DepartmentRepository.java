package com.certification.spring.aop.example7.beans;

import com.certification.spring.aop.example7.annotations.MonitoredRepository;
import com.certification.spring.aop.example7.ds.Department;
import org.springframework.stereotype.Component;

@Component
@MonitoredRepository
public class DepartmentRepository extends EmployeeBean {

    public Department findDepartment(String pattern) {
        return new Department();
    }

    public void updateDepartment(int id, Department department) {
    }
}
