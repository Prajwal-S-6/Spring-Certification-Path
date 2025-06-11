package com.spring.data.example17.service;


import com.spring.data.example17.dao.EmployeeDao;
import com.spring.data.example17.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.concurrent.CountDownLatch;

abstract class AbstractIsolationExample {
    @Autowired
    private EmployeeDao employeeDao;

    CountDownLatch fistReadOnUnsavedAndNotCommittedLatch = new CountDownLatch(1);
    CountDownLatch secondReadOnSavedButNotCommittedLatch = new CountDownLatch(1);
    CountDownLatch writeDoneNotCommittedLatch = new CountDownLatch(1);
    CountDownLatch writeDoneAndCommittedLatch = new CountDownLatch(1);
    CountDownLatch readWriteLatch = new CountDownLatch(2);

    void readOperation() {
        employeeDao.findAllEmployeesByIdRange(1, 6).forEach(System.out::println);
    }

    void writeOperation() {
        employeeDao.saveEmployee(new Employee(6, "Mary", "Duncan", "Mary.Duncam@cor.com", "555-55-60", Date.valueOf("2019-07-30"), 130000));
        employeeDao.maskEmail(3);
    }

    public CountDownLatch getFistReadOnUnsavedAndNotCommittedLatch() {
        return fistReadOnUnsavedAndNotCommittedLatch;
    }

    public CountDownLatch getSecondReadOnSavedButNotCommittedLatch() {
        return secondReadOnSavedButNotCommittedLatch;
    }

    public CountDownLatch getWriteDoneNotCommittedLatch() {
        return writeDoneNotCommittedLatch;
    }

    public CountDownLatch getWriteDoneAndCommittedLatch() {
        return writeDoneAndCommittedLatch;
    }

    public CountDownLatch getReadWriteLatch() {
        return readWriteLatch;
    }
}
