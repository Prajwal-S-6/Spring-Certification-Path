package com.spring.test.application;

import com.spring.test.ds.BookingResult;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Reservation;
import com.spring.test.ds.Room;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.GuestSharableDataService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Optional;

import static com.spring.test.ds.BookingResult.BookingState.*;
import static org.assertj.core.api.Assertions.assertThat;
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

    private static final LocalDate date = LocalDate.of(2025, 7, 24);

    @Test
    public void shouldRegisterGuests() {
        Guest guest = new Guest("P","S");
        when(guestRegistrationService.registerGuest(new Guest("P","S"))).thenReturn(guest);
        Guest registeredGuest = applicationService.registerGuest("P","S");

        verify(guestRegistrationService).registerGuest(guest);
        assertEquals(guest, registeredGuest);
    }

    @Test
    public void shouldBookAnyRoomForNewGuest() {
        Room room = new Room("A","A");
        Guest guest = new Guest("P","S");
        when(bookingService.findAvailableRoom(date)).thenReturn(Optional.of(room));
        when(applicationService.registerGuest("P","S")).thenReturn(guest);
        when(bookingService.bookRoom(room, guest, date)).thenReturn(Optional.of(new Reservation(room, guest, date)));

        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P", "S", date);

        verify(guestRegistrationService).registerGuest(guest);
        verify(bookingService).bookRoom(room, guest, LocalDate.of(2025, 7, 24));
        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isPresent();
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
        assertEquals(guest.getFirstName(), bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals(guest.getLastName(), bookingResult.getReservation().get().getGuest().getLastName());
        assertThat(bookingResult.getReservation().get().getRoom()).isNotNull();

    }

    @Test
    public void shouldBookAnyRoomForRegisteredGuest() {
        Guest guest = new Guest("P","S");
        Room room = new Room("A","A");
        when(bookingService.findAvailableRoom(date)).thenReturn(Optional.of(room));
        when(bookingService.bookRoom(room, guest, date)).thenReturn(Optional.of(new Reservation(room, guest, date)));

        BookingResult bookingResult = applicationService.bookAnyRoomForRegisteredGuest(guest, date);

        verify(bookingService).bookRoom(room, guest, LocalDate.of(2025, 7, 24));
        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isPresent();
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
        assertEquals(guest.getFirstName(), bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals(guest.getLastName(), bookingResult.getReservation().get().getGuest().getLastName());
        assertThat(bookingResult.getReservation().get().getRoom()).isNotNull();
    }

    @Test
    public void shouldSpecificRoomForRegisteredGuest() {
        Guest guest = new Guest("P", "S");
        when(bookingService.bookRoom("A", guest , date)).thenReturn(Optional.of(new Reservation(new Room("A", "A"), guest, date)));

        BookingResult bookingResult = applicationService.bookSpecificRoomForRegisteredGuest(guest, "A", date);

        verify(bookingService).bookRoom("A", guest, date);
        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isPresent();
        assertEquals("A", bookingResult.getReservation().get().getRoom().getName());
        assertEquals(guest.getFirstName(), bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals(guest.getLastName(), bookingResult.getReservation().get().getGuest().getLastName());
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
    }


}