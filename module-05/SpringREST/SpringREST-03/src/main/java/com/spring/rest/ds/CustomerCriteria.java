package com.spring.rest.ds;

import lombok.AllArgsConstructor;
import lombok.Data;


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
