package com.spring.test.application;

import com.spring.test.ds.BookingResult;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Reservation;
import com.spring.test.ds.Room;
import com.spring.test.repository.GuestRepository;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static com.spring.test.ds.BookingResult.BookingState.NO_ROOM_AVAILABLE;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {

    @InjectMocks
    private ApplicationService applicationService;

    @Mock
    private GuestRegistrationService guestRegistrationService;

    @Mock
    private BookingService bookingService;


    @Mock
    private Room room;
    @Mock
    private Guest registeredGuest;
    @Mock
    private Reservation reservation;

    private static final LocalDate date = LocalDate.of(2025, 7, 20);


    @Test
    public void shouldBookRoomForAfterConfirmingRoomAvailabilityAndRegisteringGuest() {

        when(bookingService.findAvailableRoom(date)).thenReturn(Optional.of(new Room(1,"A", "A")));
        when(guestRegistrationService.registerGuest(new Guest("P", "S"))).thenReturn(new Guest("P","S"));
        when(bookingService.bookRoom(new Room(1, "A","A"), new Guest("P","S"), date)).thenReturn(Optional.of(new Reservation(new Room(1, "A", "A"), new Guest("P", "S"), date)));

        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P","S", date);

        verify(guestRegistrationService).registerGuest(new Guest("P", "S"));
        verify(bookingService).bookRoom(new Room(1, "A","A"), new Guest("P","S"), date);


        assertEquals(BookingResult.BookingState.ROOM_BOOKED, bookingResult.getBookingState());
        assertEquals(new Reservation(new Room(1, "A", "A"), new Guest("P", "S"), date), bookingResult.getReservation().get());

    }

    @Test
    public void shouldNotBookRoomWhenNoRoomIsAvailableAndShouldNotRegisterGuest() {
        when(bookingService.findAvailableRoom(date)).thenReturn(Optional.empty());

        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P", "S", date);

        verify(guestRegistrationService, never()).registerGuest(new Guest("P", "S"));
        verify(bookingService,never()).bookRoom("A", new Guest("P","S"),date);

        assertEquals(NO_ROOM_AVAILABLE, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isEmpty();
    }

    @Test
    public void shouldBookAnyRoomForRegisteredGuests() {

        when(bookingService.findAvailableRoom(date)).thenReturn(Optional.of(new Room(1, "A", "A")));
        when(bookingService.bookRoom(new Room(1, "A","A"), new Guest("P","S"), date)).thenReturn(Optional.of(new Reservation(new Room(1, "A", "A"), new Guest("P", "S"), date)));

        BookingResult bookingResult = applicationService.bookAnyRoomForRegisteredGuest(new Guest("P", "S"),date);


        verify(bookingService).bookRoom(new Room(1, "A","A"), new Guest("P","S"), date);
        assertEquals(BookingResult.BookingState.ROOM_BOOKED, bookingResult.getBookingState());
        assertEquals(new Reservation(new Room(1, "A", "A"), new Guest("P", "S"), date), bookingResult.getReservation().get());

    }

    @Test
    public void shouldRegisterGuest() {
        Guest guest = new Guest("P","S");
        when(guestRegistrationService.registerGuest(guest)).thenReturn(new Guest(1,"P","S"));
        Guest registeredGuest = applicationService.registerGuest("P","S");

        verify(guestRegistrationService).registerGuest(guest);
        assertEquals(new Guest(1, "P","S"), registeredGuest);
    }

}