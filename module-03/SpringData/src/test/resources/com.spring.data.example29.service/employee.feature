Feature: Employee Save
  Scenario: Zero Employees
    Given All employees are deleted
    When No Employees are saved
    Then should have 0 employees saved


  Scenario: Query Employee
    Given Employees are saved
    When Queried for employee
    Then should return William employee