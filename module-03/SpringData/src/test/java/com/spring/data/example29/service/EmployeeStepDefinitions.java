package com.spring.data.example29.service;

import com.spring.data.example29.ds.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeStepDefinitions extends SpringIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    private Employee employee;

    @Given("Employees are saved")
    public void employees_are_saved() {
        employeeService.saveAllEmployees();
    }

    @When("Queried for employee")
    public void queriedForEmployee() {
        employee = employeeService.queryEmployee();
    }

    @Then("should return William employee")
    public void shouldReturnWilliamEmployee() {
        assertThat(employee.getFirstName()).isEqualTo("Willow");
        assertThat(employee.getLastName()).isEqualTo("Zhang");
        assertThat(employee.getSalary()).isEqualTo(80000);
    }
}
