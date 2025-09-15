package com.spring.data.example8.ds;


import java.sql.Date;

public record Employee(int id, String firstName, String lastName, String email, String phoneNumber, Date hireDate, float salary) {
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
