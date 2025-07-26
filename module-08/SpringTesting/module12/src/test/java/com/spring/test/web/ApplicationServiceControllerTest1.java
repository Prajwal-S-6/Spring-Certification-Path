package com.spring.test.web;

import com.spring.test.application.ApplicationService;
import com.spring.test.ds.BookingRequest;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Reservation;
import com.spring.test.ds.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
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

    @Autowired
    private JacksonTester<List<Reservation>> reservationListJson;

    @Autowired
    private JacksonTester<BookingRequest> bookingJson;



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

    @Test
    public void shouldGetListOfReservations() throws Exception {
        when(applicationService.listReservations()).thenReturn(List.of(new Reservation(1, new Room("A", "A"), new Guest("P", "S"), LocalDate.of(2025,7,26))));

        List<Reservation> reservationList = reservationListJson.parseObject(mvc.perform(MockMvcRequestBuilders.get("/api/bookings").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());

        assertThat(reservationList).contains(new Reservation(1, new Room("A", "A"), new Guest("P", "S"), LocalDate.of(2025,7,26)));
    }

    @Test
    public void shouldBookAnyRoomForRegisteredGuest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/api/bookings").contentType(MediaType.APPLICATION_JSON)
                .content(bookingJson.write(new BookingRequest(new Guest("P", "S"), LocalDate.of(2025, 7, 26))).getJson())).andExpect(status().isOk()).andReturn();

        verify(applicationService).bookAnyRoomForRegisteredGuest(new Guest("P", "S"), LocalDate.of(2025, 7, 26));

    }



}