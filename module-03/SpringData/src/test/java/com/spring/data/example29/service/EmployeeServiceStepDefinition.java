package com.spring.data.example29.service;

import com.spring.data.example29.ds.Employee;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import io.cucumber.java8.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@CucumberContextConfiguration
public class EmployeeServiceStepDefinition implements En {

    @Autowired
    EmployeeService employeeService;

    Employee result;

//    @Given("Employees are Saved")
//    public void employeesSaved() {
//        employeeService.saveAllEmployees();
//    }
//
//    @When("Queried for Employee")
//    public void queryForEmployee() {
//        result = employeeService.queryEmployee();
//    }

//    @Then("Should return Willow Employee")
//    public void shouldReturnEmployee() {
//       assertThat(result.getFirstName()).isEqualTo("Willow");
//       assertThat(result.getLastName()).isEqualTo("Zhang");
//       assertThat(result.getSalary()).isEqualTo(80000);
//    }

    EmployeeServiceStepDefinition() {
        Given("^Employees are Saved", () -> {
            employeeService.saveAllEmployees();
        });

        When("^Queried for Employee", () -> {
            result = employeeService.queryEmployee();
        });

        Then("^Should return Willow Employee", () -> {
            assertThat(result.getFirstName()).isEqualTo("Willow");
            assertThat(result.getLastName()).isEqualTo("Zhang");
            assertThat(result.getSalary()).isEqualTo(80000);
        });
    }
}
