package com.certification.spring.preparation.proxy.cglib;


import com.certification.spring.preparation.dao.DepartmentDao;
import com.certification.spring.preparation.ds.Department;
import org.springframework.cglib.proxy.Enhancer;

public class Runner {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new DepartmentDaoMethodInterceptor());
        enhancer.setSuperclass(DepartmentDao.class);
        DepartmentDao departmentDao = (DepartmentDao) enhancer.create();

        Department department = departmentDao.findById(5);
        departmentDao.save(department);
    }
}
