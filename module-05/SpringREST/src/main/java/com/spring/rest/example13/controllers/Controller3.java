package com.spring.rest.example13.controllers;

import com.spring.rest.example13.ds.Customer;
import com.spring.rest.example13.ds.CustomerStatistics;
import com.spring.rest.example13.ds.Statistics;
import com.spring.rest.example13.service.CustomerStatisticsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller3 {

    @Autowired
    private CustomerStatisticsService customerStatisticsService;

    @PostMapping("/api/v3")
    @ResponseBody
    public CustomerStatistics getStatistics(@RequestBody(required = false) @Valid Customer customer) {
        if(customer != null)
            return new CustomerStatistics(customer, customerStatisticsService.calculcateStatistics(customer));
        else
            return new CustomerStatistics(new Customer(), new Statistics());
    }
}
