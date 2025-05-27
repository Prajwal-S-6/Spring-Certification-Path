package com.certification.spring.preparation.example2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean1 {

    @Value("Prajwal")
    private String name;

    @Value("#{'Wall street'.toUpperCase()}")
    private String streetName;

    @Value("false")
    private boolean isAccountExists;

    @Value("100")
    private Integer idNumber;

    @Value("#{5000 * 2}")
    private Integer accountBalance;

    public String getName() {
        return name;
    }

    public String getStreetName() {
        return streetName;
    }

    public boolean isAccountExists() {
        return isAccountExists;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }
}
