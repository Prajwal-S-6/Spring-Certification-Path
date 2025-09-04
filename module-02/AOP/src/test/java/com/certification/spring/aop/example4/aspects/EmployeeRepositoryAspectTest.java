package com.certification.spring.aop.example4.aspects;

import com.certification.spring.aop.example4.ApplicationConfig;
import com.certification.spring.aop.example4.ds.Employee;
import com.certification.spring.aop.example4.service.a.EmployeeRepository;
import com.certification.spring.aop.example4.service.a.EmployeeRepositoryImpl;
import com.certification.spring.aop.example4.service.b.AlternateEmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

        assertThat(logMessage).isEmpty();

    }

    @Test
    void shouldNotLogForSelfInvokingMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));

        employeeRepository.saveEmployee(new Employee());
        employeeRepository.deleteEmployee(new Employee());
        employeeRepository.findAndUpdateEmployeeById(1L , new Employee());


        System.setOut(originalOutput);
        String logMessage = byteArrayOutputStream.toString();

}