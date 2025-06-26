package com.spring.rest.example10.controller;

import com.spring.rest.example10.dao.AddressDao;
import com.spring.rest.example10.dao.CustomerDao;
import com.spring.rest.example10.ds.Address;
import com.spring.rest.example10.ds.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("api/v2")
public class ApiController2 {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @GetMapping("customers")
    @ResponseBody
    public List<Customer> listCustomers() {
        return customerDao.findAll();
    }

    @GetMapping("addresses")
    @ResponseBody
    public List<Address> listAddresses() {
        return addressDao.findAll();
    }
}
