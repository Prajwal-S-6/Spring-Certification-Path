package com.spring.rest.example3.dao;

import com.spring.rest.example3.ds.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
