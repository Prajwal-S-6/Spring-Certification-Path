package com.spring.data.example23.jta.transaction.manager.service;


import com.spring.data.example23.jta.transaction.manager.db.employee.dao.EmployeeDao;
import com.spring.data.example23.jta.transaction.manager.db.employee.ds.Employee;
import com.spring.data.example23.jta.transaction.manager.db.products.dao.ProductDao;
import com.spring.data.example23.jta.transaction.manager.db.products.ds.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeProductService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ProductDao productDao;

    @Transactional
    public void purgeData() {
        employeeDao.deleteAll();
        productDao.deleteAll();
    }

    @Transactional
    public void saveData() {
        System.out.println("Saving employee 1");
        employeeDao.save(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        System.out.println("Saved employee 1");

        System.out.println("Saving product 1");
        productDao.save(new Product(1, "Jet Ski", 20, 4799f, true));
        System.out.println("Saved product 1");

        //System.out.println("Throwing exception to revert transaction");
        //throw new IllegalArgumentException();
    }

    @Transactional
    public void listAllData() {
        System.out.println("Listing all employees...");
        employeeDao.findAll().forEach(System.out::println);

        System.out.println("Listing all products...");
        productDao.findAll().forEach(System.out::println);
    }
}
