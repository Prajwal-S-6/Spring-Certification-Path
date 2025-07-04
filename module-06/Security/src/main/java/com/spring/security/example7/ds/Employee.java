package com.spring.security.example7.ds;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import static jakarta.persistence.GenerationType.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "First name contains illegal characters")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "Last name contains illegal characters")
    private String lastName;
    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "[0-9\\-+]*", message = "Phone number contains illegal characters")
    private String phoneNumber;
    @NotBlank(message = "Address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address contains illegal characters")
    private String address;
    @NotBlank(message = "Cubicle No cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9\\-]*", message = "Cubicle No contains illegal characters")
    private String cubicleNo;


    public Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, String phoneNumber, String address, String cubicleNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cubicleNo = cubicleNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCubicleNo() {
        return cubicleNo;
    }

    public void setCubicleNo(String cubicleNo) {
        this.cubicleNo = cubicleNo;
    }
}
