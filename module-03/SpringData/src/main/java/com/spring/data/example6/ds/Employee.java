package com.spring.data.example6.ds;


import java.sql.Date;

public record Employee(int id, String firstName, String lastName, String email, String phoneNumber, Date hireDate, float salary) {
}
