package com.spring.rest.example5.dao;

import com.spring.rest.example5.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
