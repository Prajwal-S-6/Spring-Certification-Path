package com.spring.security.example4.dao;

import com.spring.security.example4.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
