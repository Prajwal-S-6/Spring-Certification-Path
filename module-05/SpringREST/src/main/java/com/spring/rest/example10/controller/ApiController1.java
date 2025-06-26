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
@ResponseBody
@RequestMapping("api/v1")
public class ApiController1 {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @GetMapping("customers")
    public List<Customer> listCustomers() {
        return customerDao.findAll();
    }

    @GetMapping("addresses")
    public List<Address> listAddresses() {
        return addressDao.findAll();
    }
}
