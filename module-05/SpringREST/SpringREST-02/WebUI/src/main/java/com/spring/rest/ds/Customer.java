package com.spring.rest.ds;




public class Customer {
    private Integer id;
    private String code;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(Integer id, String code, String firstName, String lastName) {
        this.id = id;
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
