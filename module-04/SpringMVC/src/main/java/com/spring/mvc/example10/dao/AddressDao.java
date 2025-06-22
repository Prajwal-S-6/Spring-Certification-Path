package com.spring.mvc.example10.dao;

import com.spring.mvc.example10.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer> {
}
