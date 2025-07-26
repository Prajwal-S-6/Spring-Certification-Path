package com.spring.test.application;

import com.spring.test.ds.Guest;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.GuestSharableDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private GuestRegistrationService guestRegistrationService;

    @Autowired
    private BookingService bookingService;

    @MockitoBean
    private GuestSharableDataService guestSharableDataService;

    @Test
    public void shouldRegisterGuest() {
        Guest registeredGuest = applicationService.registerGuest("P", "S");
        assertThat(registeredGuest.getId()).isNotNull();
        assertEquals("P", registeredGuest.getFirstName());
        assertEquals("S", registeredGuest.getLastName());
        assertThat(guestRegistrationService.listGuests().stream().map(g -> g.getFirstName() + " " + g.getLastName()).toList()).contains("P S");
    }

    @Test
    public void shouldGetGuestSharableData() {
        when(guestSharableDataService.getGuestSharableData()).thenReturn("PS, HS, GK");

        String guestSharableData = applicationService.getGuestSharableData();

        assertThat(guestSharableData).isEqualTo("PS, HS, GK");
    }

}