package com.spring.test.application;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test.ds.Guest;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.GuestSharableDataService;
import jakarta.annotation.Resource;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ApplicationServiceIntegrationTest {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private GuestRegistrationService guestRegistrationService;

    @Autowired
    private GuestSharableDataService guestSharableDataServiceMock;

    @Test
    public void shouldGetSharableData() {
        applicationService.registerGuest("P","S");
        applicationService.registerGuest("H","S");
        applicationService.registerGuest("G","K");

        when(guestSharableDataServiceMock.getGuestSharableData()).thenReturn("PS, HS, GK");

        String data = applicationService.getGuestSharableData();

        verify(guestSharableDataServiceMock).getGuestSharableData();
        assertThat(data).isEqualTo("PS, HS, GK");
    }


    @Test
    public void shouldRegisterGuest() {
        Guest registereduest = applicationService.registerGuest("P","S");

        assertThat(guestRegistrationService.listGuests().stream().map(Guest::getId).toList()).isNotEmpty();
        assertNotNull(registereduest.getId());
        assertEquals("P",registereduest.getFirstName());
        assertEquals("S", registereduest.getLastName());
    }



}