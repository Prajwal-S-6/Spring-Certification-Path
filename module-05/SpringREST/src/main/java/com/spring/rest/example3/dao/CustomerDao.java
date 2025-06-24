package com.spring.rest.example3.dao;


import com.spring.rest.example3.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
