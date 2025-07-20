package com.spring.boot.controller;

import com.spring.boot.dao.CityDao;
import com.spring.boot.entity.City;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
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
class CityControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private CityDao cityDao;

    @Test
    public void shouldSaveCities() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/cities").contentType(MediaType.APPLICATION_JSON).content("{ \"name\": \"A\" }")).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.put("/cities").contentType(MediaType.APPLICATION_JSON).content("{ \"name\": \"B\" }")).andExpect(status().isOk());

        verify(cityDao).save(new City("A"));
        verify(cityDao).save(new City("B"));
    }

    @Test
    public void shouldFetchCities() throws Exception {
        when(cityDao.findAll()).thenReturn(Arrays.asList(new City(1,"A"),new City(2,"B")));
        String res = mvc.perform(MockMvcRequestBuilders.get("/cities")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertThat(res).contains("{\"id\":1,\"name\":\"A\"}").contains("{\"id\":2,\"name\":\"B\"}");

    }

}