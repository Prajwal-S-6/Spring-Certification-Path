package com.spring.data.example8.service;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.spring.data.example3.jdbc.template.service.TestDataSourceConfig;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Import(TestDataSourceConfig.class)
@ActiveProfiles("test")
class EmployeesServiceTest {

    @Autowired
    private EmployeesService employeesService;

    Logger logger = (Logger) LoggerFactory.getLogger(EmployeesService.class);

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
    void shouldDeleteAllEmployees() {
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        logger.addAppender(listAppender);
        listAppender.start();

        List<ILoggingEvent> logs = listAppender.list;
        employeesService.deleteAllEmployees();
        employeesService.printEmployees();

        Approvals.verify(logs.stream().map(ILoggingEvent::getFormattedMessage).reduce((log1, log2) -> log1 + "\n" + log2).get());

    }
}