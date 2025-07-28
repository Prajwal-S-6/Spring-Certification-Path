package com.spring.test.web;

import com.spring.test.ds.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationServiceControllerIntegrationTest2 {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String url;

    @BeforeEach
    void setUp() {
        url = String.format("http://localhost:%d",port);
    }

    @Test
    public void shouldRegisterGuest() {

        Guest guest = new Guest("P", "S");
        Guest guest1 = new Guest("H", "S");
        testRestTemplate.put(url+"/api/guests", guest);
        testRestTemplate.put(url+"/api/guests", guest1);

        ResponseEntity<List<Guest>> responseEntity = testRestTemplate.exchange(url+"/api/guests", HttpMethod.GET, null, new ParameterizedTypeReference<List<Guest>>() {});

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }



}