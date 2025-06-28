package com.spring.rest.dao;

import com.spring.rest.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersDao extends JpaRepository<Customer, Integer> {
}
