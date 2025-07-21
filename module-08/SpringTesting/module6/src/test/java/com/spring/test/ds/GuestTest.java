package com.spring.test.ds;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.Assert.*;

public class GuestTest {

    @Test
    public void shouldCreateNewGuestWithFirstAndLastName() {
        Guest guest = new Guest("P","S");

        assertNull(guest.getId());
        assertEquals("P", guest.getFirstName());
        assertEquals("S", guest.getLastName());
    }

    @Test
    public void setIdForGuest() {
        Guest guest = new Guest();
        ReflectionTestUtils.setField(guest, "id", 123, Integer.class);

        assertEquals(Integer.valueOf(123), guest.getId());
    }
}