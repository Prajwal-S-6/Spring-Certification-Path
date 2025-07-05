package com.spring.security.example8.dao;

import com.spring.security.example8.ds.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    @PostFilter("hasRole('ROLE_CUSTOMERS_READ') || (hasRole('ROLE_CUSTOMERS_QA') && filterObject.getFirstName().equals('TEST'))")
    @Override
    List<Customer> findAll();


    @PostAuthorize("hasRole('ROLE_CUSTOMERS_READ') || (hasRole('CUSTOMERS_QA') && returnObject.isPresent() && returnObject.getFirstName().equals('TEST'))")
    @Override
    Optional<Customer> findById(Integer id);



    @PreFilter("hasRole('ROLE_CUSTOMERS_CREATE') || (hasRole('CUSTOMERS_QA') && filterObject.getFirstName().equals('TEST'))")
    @Override
    <S extends Customer> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('ROLE_CUSTOMERS_DELETE') || (hasRole('CUSTOMERS_QA') && 'TEST'.equals(#entity.getFirstName()))")
    @Override
    void delete(Customer entity);
}
