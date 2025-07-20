package com.spring.boot.controller;

import com.spring.boot.dao.CityDao;
import com.spring.boot.ds.Cities;
import com.spring.boot.ds.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = CityController.class)
class CityControllerSmallSpringBootTest {

    @Autowired
    private CityController cityController;

    @MockitoBean
    private CityDao cityDao;


    @Test
    public void shouldSaveCities() {
        cityController.putCity(new City("A"));
        cityController.putCity(new City("B"));

        verify(cityDao).save(new City("A"));
        verify(cityDao).save(new City("B"));
    }

    @Test
    public void shouldGetCities() {
        when(cityDao.findAll()).thenReturn(Arrays.asList(new City("A"), new City("B")));

        Cities cities = cityController.getCities();

        assertThat(cities.getCities()).containsOnly(new City("A"), new City("B"));
    }

}