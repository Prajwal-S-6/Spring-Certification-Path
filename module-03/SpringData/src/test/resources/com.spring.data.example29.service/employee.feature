Feature: Employee Save

  Scenario: Query Employee
    Given Employees are saved
    When Queried for employee
    Then should return William employee