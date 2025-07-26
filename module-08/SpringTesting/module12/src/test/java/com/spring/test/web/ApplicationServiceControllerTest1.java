package com.spring.test.web;

import com.spring.test.application.ApplicationService;
import com.spring.test.ds.Guest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApplicationServiceController.class)
@AutoConfigureJsonTesters
class ApplicationServiceControllerTest1 {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private ApplicationService applicationService;

    @Autowired
    private JacksonTester<Guest> guestJson;

    @Autowired
    private JacksonTester<List<Guest>> listOfGuest;



    @Test
    public void shouldGetListOfGuests() throws Exception {
        when(applicationService.listGuests()).thenReturn(List.of(new Guest(1,"P", "S"), new Guest(2,"H", "S")));
        List<Guest> guests = listOfGuest.parseObject(mvc.perform(MockMvcRequestBuilders.get("/api/guests")
                        .contentType("/application/json"))
                .andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString());
        assertEquals(List.of(new Guest(1,"P", "S"), new Guest(2,"H", "S")), guests);
    }


    @Test
    public void shouldRegisterGuest() throws Exception {
        Guest guest = new Guest("P", "S");
        when(applicationService.registerGuest(guest)).thenReturn(new Guest(1, "P", "S"));

        MvcResult result = mvc.perform(MockMvcRequestBuilders.put("/api/guests")
                .contentType("application/json")
                .content(guestJson.write(guest).getJson()))
                .andExpect(status().isOk())
                .andReturn();

        Guest registeredGuest = guestJson.parseObject(result.getResponse().getContentAsString());
        assertEquals(new Guest(1,"P", "S"), registeredGuest);
    }

}