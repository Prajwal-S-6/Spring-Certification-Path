package com.spring.test.web;

import com.spring.test.ds.BookingRequest;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Reservation;
import com.spring.test.ds.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ApplicationServiceControllerIntegrationTest {

    @Autowired
    private ApplicationServiceController applicationServiceController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JacksonTester<List<Guest>> guestsJson;

    @Autowired
    JacksonTester<Guest> guestJson;

    @Autowired
    JacksonTester<BookingRequest> reservationJson;

    @Autowired
    JacksonTester<List<Reservation>> listJacksonTester;


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



    @Test
    public void shouldBookAnyRoomForRegisteredGuest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/guests").contentType(MediaType.APPLICATION_JSON)
                        .content(guestJson.write(new Guest("H","S")).getJson()))
                .andExpect(status().isOk())
                .andReturn();

        Guest guest = guestJson.parseObject(mvcResult.getResponse().getContentAsString());

        Room room = new Room(UUID.randomUUID(),"A", "A");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/bookings").contentType(MediaType.APPLICATION_JSON)
                .content(reservationJson.write(new BookingRequest(guest, LocalDate.of(2025,7,27))).getJson()))
                .andExpect(status().isOk())
                .andReturn();

        List<Reservation> reservationList = listJacksonTester.parseObject(mockMvc.perform(MockMvcRequestBuilders.get("/api/bookings").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());


        assertThat(reservationList).isNotEmpty();
        assertEquals(LocalDate.of(2025, 7,27), reservationList.get(0).getReservationDate());
        assertEquals(guest, reservationList.get(0).getGuest());

    }


}