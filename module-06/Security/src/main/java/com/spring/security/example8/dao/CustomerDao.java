package com.spring.security.example8.dao;

import com.spring.security.example8.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {


}
