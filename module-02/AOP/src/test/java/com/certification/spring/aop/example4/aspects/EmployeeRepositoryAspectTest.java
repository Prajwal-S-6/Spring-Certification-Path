package com.certification.spring.aop.example4.aspects;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.certification.spring.aop.example4.ApplicationConfig;
import com.certification.spring.aop.example4.ds.Employee;
import com.certification.spring.aop.example4.service.a.EmployeeRepository;
import com.certification.spring.aop.example4.service.a.EmployeeRepositoryImpl;
import com.certification.spring.aop.example4.service.b.AlternateEmployeeRepository;
import org.apache.commons.logging.Log;
import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.core.Scrubber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import static java.util.logging.Level.INFO;
import static org.approvaltests.Approvals.verifyAll;
import static org.approvaltests.utils.logger.SimpleLoggerApprovals.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
class EmployeeRepositoryAspectTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AlternateEmployeeRepository alternateEmployeeRepository;


    @Test
    void shouldNotLogForFinalMethods() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));

        alternateEmployeeRepository.deleteEmployee(new Employee());
        alternateEmployeeRepository.saveEmployee(new Employee());
        alternateEmployeeRepository.findEmployeeById(1L);
        alternateEmployeeRepository.findAndUpdateEmployeeById(1L, new Employee());

        System.setOut(originalOutput);
        String logMessage = byteArrayOutputStream.toString();

        assertThat(logMessage).contains(List.of("Before - findAndUpdateEmployeeById", "After - findAndUpdateEmployeeById"));

    }

    @Test
    void shouldNotLogForSelfInvokingMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Logger logger = (Logger) LoggerFactory.getLogger(EmployeeRepositoryAspect.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        logger.addAppender(listAppender);
        listAppender.start();

        employeeRepository.saveEmployee(new Employee());
        employeeRepository.deleteEmployee(new Employee());
        employeeRepository.findAndUpdateEmployeeById(1L , new Employee());

        List<ILoggingEvent> logs = listAppender.list;
        Approvals.verify(logs.stream().map(String::valueOf).reduce((log1, log2) -> log1 + ",\n" + log2).get());
        assertThat(logs.get(0).getLevel().levelStr).isEqualTo(INFO.getName());
    }

}