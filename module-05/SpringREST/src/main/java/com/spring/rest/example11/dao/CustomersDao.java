package com.spring.rest.example11.dao;

import com.spring.rest.example11.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersDao extends JpaRepository<Customer, Integer> {
}
