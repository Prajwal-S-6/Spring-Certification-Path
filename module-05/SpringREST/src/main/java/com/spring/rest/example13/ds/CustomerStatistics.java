package com.spring.rest.example13.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


public class CustomerStatistics {

    private Customer customer;
    private Statistics statistics;

    public CustomerStatistics(Customer customer, Statistics statistics) {
        this.customer = customer;
        this.statistics = statistics;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
}
