package com.spring.test.web;

import com.spring.test.ds.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ApplicationServiceControllerIntegrationTest {

    @Autowired
    private ApplicationServiceController applicationServiceController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JacksonTester<List<Guest>> guestsJson;

    @Autowired
    JacksonTester<Guest> guestJson;


    @Test
    public void shouldRegisterGuest() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/guests").contentType(MediaType.APPLICATION_JSON)
                .content(guestJson.write(new Guest("P","S")).getJson()))
                .andExpect(status().isOk())
                .andReturn();

        Guest guest = guestJson.parseObject(mvcResult.getResponse().getContentAsString());

        assertThat(guest.getId()).isNotNull();
        assertEquals("P", guest.getFirstName());
        assertEquals("S", guest.getLastName());
    }

    @Test
    public void shouldGetlistofGuests() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/guests").contentType(MediaType.APPLICATION_JSON)
                        .content(guestJson.write(new Guest("H","S")).getJson()))
                .andExpect(status().isOk())
                .andReturn();

        List<Guest> guests = guestsJson.parseObject(mockMvc.perform(MockMvcRequestBuilders.get("/api/guests").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString());

        assertThat(guests).contains(new Guest(1, "H", "S"));
    }






}