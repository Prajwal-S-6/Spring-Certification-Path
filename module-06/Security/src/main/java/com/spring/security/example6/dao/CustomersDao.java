package com.spring.security.example6.dao;


import com.spring.security.example6.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
