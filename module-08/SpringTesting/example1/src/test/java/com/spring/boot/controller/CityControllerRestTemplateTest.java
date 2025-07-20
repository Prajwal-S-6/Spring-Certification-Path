package com.spring.boot.controller;

import com.spring.boot.ds.Cities;
import com.spring.boot.ds.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CityControllerRestTemplateTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int serverPort;


    @Test
    public void shouldSaveCities() {

        String url = String.format("http://localhost:%d/cities", serverPort);
        testRestTemplate.put(url, new City("A"));
        testRestTemplate.put(url, new City("B"));

        Cities cities = testRestTemplate.getForEntity(url,Cities.class).getBody();

        assertThat(cities.getCities()).containsOnly(new City(1,"A"),new City(2, "B"));
    }

}