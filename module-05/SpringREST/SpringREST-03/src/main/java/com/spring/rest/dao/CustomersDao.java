package com.spring.rest.dao;

import com.spring.rest.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersDao extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstNameLike(String firstNameLike);
}
