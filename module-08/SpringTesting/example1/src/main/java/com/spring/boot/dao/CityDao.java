package com.spring.boot.dao;


import com.spring.boot.ds.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends CrudRepository<City, Integer> {
}
