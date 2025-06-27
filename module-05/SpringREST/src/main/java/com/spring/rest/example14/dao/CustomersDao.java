package com.spring.rest.example14.dao;


import com.spring.rest.example14.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersDao extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstNameLike(String firstNameLike);
}
