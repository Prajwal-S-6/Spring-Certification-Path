package com.spring.boot.controller;

import com.spring.boot.ds.Cities;
import com.spring.boot.ds.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CityControllerWebIntegrationTest {

    @LocalServerPort
    private int serverPort;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void shouldSaveCities() {
        String uri = String.format("http://localhost:%d/cities", serverPort);

        testRestTemplate.put(uri, new City("A"));
        testRestTemplate.put(uri, new City("B"));

        Cities cities = testRestTemplate.getForEntity(uri, Cities.class).getBody();

        assertThat(cities.getCities()).containsOnly(new City(1, "A"),new City(2, "B"));
    }

}