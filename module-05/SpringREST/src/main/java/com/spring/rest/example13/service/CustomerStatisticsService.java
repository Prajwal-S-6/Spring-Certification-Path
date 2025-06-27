package com.spring.rest.example13.service;


import com.spring.rest.example13.ds.Customer;
import com.spring.rest.example13.ds.Statistics;
import org.springframework.stereotype.Service;

@Service
public class CustomerStatisticsService {

    public Statistics calculcateStatistics(Customer customer) {
        int codeLength = customer.getCode().length();
        int firstNameLength = customer.getFirstName().length();
        int lastNameLength = customer.getLastName().length();

        return new Statistics(
                codeLength + firstNameLength + lastNameLength,
                codeLength, firstNameLength, lastNameLength
        );
    }
}
