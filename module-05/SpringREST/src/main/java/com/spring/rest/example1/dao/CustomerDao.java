package com.spring.rest.example1.dao;

import com.spring.rest.example1.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
