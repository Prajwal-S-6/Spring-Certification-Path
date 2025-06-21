package com.spring.mvc.example9.dao;

import com.spring.mvc.example9.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer> {
}
