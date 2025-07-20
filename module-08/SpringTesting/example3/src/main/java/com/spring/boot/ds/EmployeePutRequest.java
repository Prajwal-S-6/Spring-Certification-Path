package com.spring.boot.ds;


public class EmployeePutRequest {
    private String name;
    private String city;

    @SuppressWarnings("unused")
    public EmployeePutRequest() {
    }

    public EmployeePutRequest(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
