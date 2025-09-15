package com.spring.data.example8.service;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.spring.data.example3.jdbc.template.service.TestDataSourceConfig;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@SpringBootTest
@Import(TestDataSourceConfig.class)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.MethodName.class)  // setting test method order to simulate test fail
//@Transactional
// making @Transactional will roll back the deletion -- fixes test fail
// (Pitfall) - check @Transactional added on EmployeeService method
class EmployeesServiceTest {

    @Autowired
    private EmployeesService employeesService;

    Logger logger = (Logger) LoggerFactory.getLogger(EmployeesService.class);

    @Test
    @Transactional
    void shouldDeleteAllEmployees() {
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        logger.addAppender(listAppender);
        listAppender.start();

        List<ILoggingEvent> logs = listAppender.list;
        employeesService.deleteAllEmployees();
        employeesService.printEmployees();

        Approvals.verify(logs.stream().map(ILoggingEvent::getFormattedMessage).reduce((log1, log2) -> log1 + "\n" + log2).get());
    }

    @Test
    void shouldLogAllEmployees() {
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        logger.addAppender(listAppender);
        listAppender.start();

        List<ILoggingEvent> logs = listAppender.list;
        employeesService.printEmployees();

        Approvals.verify(logs.stream().map(ILoggingEvent::getFormattedMessage).reduce((log1, log2) -> log1 + "\n" + log2).get());
    }

    @Test
    @Transactional
    void shouldSaveThreeEmployeesWithoutTransactional() throws Exception {
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        logger.addAppender(listAppender);
        listAppender.start();

        List<ILoggingEvent> logs = listAppender.list;

        try {
            employeesService.saveEmployeesWithoutTransaction();
        }catch (Exception e) {

        }
        employeesService.printEmployees();

        Approvals.verify(logs.stream().map(ILoggingEvent::getFormattedMessage).reduce((log1, log2) -> log1 + "\n" + log2).get());
    }

    @Test
    void shouldSaveZeroEmployeesWithTransactional() throws Exception {
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        logger.addAppender(listAppender);
        listAppender.start();

        List<ILoggingEvent> logs = listAppender.list;
        try {
            employeesService.saveEmployeesInTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeesService.printEmployees();

        Approvals.verify(logs.stream().map(ILoggingEvent::getFormattedMessage).reduce((log1, log2) -> log1 + "\n" + log2).get());
    }

}