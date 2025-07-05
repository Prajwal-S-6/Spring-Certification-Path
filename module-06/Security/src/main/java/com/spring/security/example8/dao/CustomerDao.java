package com.spring.security.example8.dao;

import com.spring.security.example8.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    @PostFilter("hasRole('CUSTOMERS_ADMIN') || (hasRole('CUSTOMERS_QA') && filterObject.getFirstName().equals('TEST'))")
    @Override
    List<Customer> findAll();


    @PostAuthorize("hasRole('CUSTOMERS_ADMIN') || (hasRole('CUSTOMERS_QA') && returnObject.isPresent() && returnObject.getFirstName().equals('TEST'))")
    @Override
    Optional<Customer> findById(Integer id);


}
