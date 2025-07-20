package com.spring.boot.controller;

import com.spring.boot.dao.CityDao;
import com.spring.boot.ds.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CityControllerMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldSaveCities() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/cities").content("{ \"name\": \"A\" }").contentType("application/json")).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.put("/cities").content("{ \"name\": \"B\" }").contentType("application/json")).andExpect(status().isOk());

        String res = mvc.perform(MockMvcRequestBuilders.get("/cities")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertThat(res).contains("{\"id\":1,\"name\":\"A\"}")
                .contains("{\"id\":2,\"name\":\"B\"}");
    }

}