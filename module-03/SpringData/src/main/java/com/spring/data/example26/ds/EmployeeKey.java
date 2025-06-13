package com.spring.data.example26.ds;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeKey {
    private String firstName;
    private String lastName;

    public EmployeeKey(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public EmployeeKey() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
