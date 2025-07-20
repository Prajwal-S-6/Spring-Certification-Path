package com.spring.boot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CityControllerMockMvcFullTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldSaveListOfCities() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/cities").content("{ \"name\": \"Los Angeles\" }").contentType("application/json")).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.put("/cities").content("{ \"name\": \"California\" }").contentType("application/json")).andExpect(status().isOk());

        String mvcResult = mvc.perform(MockMvcRequestBuilders.get("/cities")).andReturn().getResponse().getContentAsString();

        assertThat(mvcResult)
                .contains("{\"id\":1,\"name\":\"Los Angeles\"}")
                .contains("{\"id\":2,\"name\":\"California\"}");
    }

}