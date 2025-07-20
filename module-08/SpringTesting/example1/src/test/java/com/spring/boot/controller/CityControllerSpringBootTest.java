package com.spring.boot.controller;

import com.spring.boot.ds.Cities;
import com.spring.boot.ds.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityControllerSpringBootTest {

    @Autowired
    private CityController cityController;

    @Test
    public void shouldSaveCities() {
        cityController.putCity(new City("A"));
        cityController.putCity(new City("B"));
        cityController.putCity(new City("C"));

        Cities cities = cityController.getCities();

        assertThat(cities.getCities()).containsOnly(new City(1,"A"), new City(2, "B"),new City(3, "C"));
    }

}