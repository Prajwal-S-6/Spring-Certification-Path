package com.spring.test.application;

import com.spring.test.ds.Guest;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.GuestSharableDataService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceUnitTest {

    @InjectMocks
    private ApplicationService applicationService;

    @Mock
    private BookingService bookingService;

    @Mock
    private GuestRegistrationService guestRegistrationService;

    @Mock
    private GuestSharableDataService guestSharableDataService;


    @Test
    public void shouldRegisterGuests() {
        Guest guest = new Guest("P","S");
        when(guestRegistrationService.registerGuest(new Guest("P","S"))).thenReturn(guest);
        Guest registeredGuest = applicationService.registerGuest("P","S");

        verify(guestRegistrationService).registerGuest(guest);
        assertEquals(guest, registeredGuest);
    }

}