package com.spring.rest.example5.dao;

import com.spring.rest.example5.ds.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
