package com.spring.rest.example11.ds;




public class CustomerCriteria {
    private String firstNameLike;


    public CustomerCriteria() {
    }

    public CustomerCriteria(String firstNameLike) {
        this.firstNameLike = firstNameLike;
    }

    public String getFirstNameLike() {
        return firstNameLike;
    }

    public void setFirstNameLike(String firstNameLike) {
        this.firstNameLike = firstNameLike;
    }
}
