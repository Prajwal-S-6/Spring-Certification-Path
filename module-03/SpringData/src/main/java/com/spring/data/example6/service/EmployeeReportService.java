package com.spring.data.example6.service;
;
import ch.qos.logback.classic.Logger;
import com.spring.data.example6.dao.EmployeeDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeReportService {

    Logger logger = (Logger) LoggerFactory.getLogger(EmployeeReportService.class);

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        logger.debug("Employee Report Start");

        employeeDao.findEmployeesCount();
        employeeDao.findEmployeesCount();
        employeeDao.findEmployeesCount();
        employeeDao.findEmployeesCount();
        employeeDao.findEmployeesCount();

        logger.debug("Employee Report End");
    }

    @Transactional
    public void printReportInTransaction() {
        logger.debug("Employee Report Start - Transactional");

        employeeDao.findEmployeesCount();
        employeeDao.findEmployeesCount();
        employeeDao.findEmployeesCount();
        employeeDao.findEmployeesCount();
        employeeDao.findEmployeesCount();

        logger.debug("Employee Report End - Transactional");
    }
}
