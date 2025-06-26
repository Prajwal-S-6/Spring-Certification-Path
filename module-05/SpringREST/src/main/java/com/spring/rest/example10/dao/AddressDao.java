package com.spring.rest.example10.dao;

import com.spring.rest.example10.ds.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
