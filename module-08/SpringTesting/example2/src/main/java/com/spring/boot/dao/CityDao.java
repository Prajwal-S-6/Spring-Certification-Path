package com.spring.boot.dao;

import com.spring.boot.ds.City;
import org.springframework.data.repository.CrudRepository;

public interface CityDao extends CrudRepository<City, Integer> {
}
