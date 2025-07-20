package com.spring.boot.dao;


import com.spring.boot.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityDao extends CrudRepository<City, Integer> {
    Optional<City> findByName(String name);
}
