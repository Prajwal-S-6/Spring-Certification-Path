package com.spring.boot.controller;

import com.spring.boot.dao.CityDao;
import com.spring.boot.ds.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CityController.class)
class CityControllerMockMvcSingleTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private CityDao cityDao;


    @Test
    public void shouldSaveCities() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/cities").content("{ \"name\": \"Los Angeles\" }")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(cityDao).save(new City(null, "Los Angeles"));
    }

    @Test
    public void shouldFetchCities() throws Exception {
        //arrange
        when(cityDao.findAll()).thenReturn(Arrays.asList(new City(1, "A"), new City(2, "B")));

        //act
        String response = mvc.perform(MockMvcRequestBuilders.get("/cities")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        //assert
        assertThat(response).contains("{\"id\":1,\"name\":\"A\"}")
                .contains("{\"id\":2,\"name\":\"B\"}");


    }



}