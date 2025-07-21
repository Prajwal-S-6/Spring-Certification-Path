package com.spring.test.service;

import com.spring.test.ds.Guest;
import com.spring.test.repository.GuestRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;


public class GuestRegistrationServiceTest {

    private GuestRegistrationService guestRegistrationService;
    private Guest guest;
    private GuestRepository guestRepository;

    @Before
    public void init() {
        guestRegistrationService = new GuestRegistrationService();
        guestRepository = mock(GuestRepository.class);
        guest = mock(Guest.class);
        ReflectionTestUtils.setField(guestRegistrationService, "guestRepository", guestRepository, GuestRepository.class);
    }

    @Test
    public void shouldRegisterGuest() {
        Guest guest1 = new Guest("P","S");

        guestRegistrationService.registerGuest(guest1);

        verify(guestRepository).save(guest1);
    }

    @Test
    public void shouldNotRegisterGuestWhenGuestIdIsNull() {
        Guest guest1 = new Guest();
        guest1.setId(1);

        assertThrows(IllegalArgumentException.class, ()-> {
            guestRegistrationService.registerGuest(guest1);
        });
        verify(guestRepository,  never()).save(guest1);

    }

}