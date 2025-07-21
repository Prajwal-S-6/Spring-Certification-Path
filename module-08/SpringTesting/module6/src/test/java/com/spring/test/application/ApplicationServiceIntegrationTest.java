package com.spring.test.application;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test.ds.BookingResult;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Reservation;
import com.spring.test.ds.Room;
import com.spring.test.repository.GuestRepository;
import com.spring.test.repository.ReservationRepository;
import com.spring.test.repository.RoomRepository;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static com.spring.test.ds.BookingResult.BookingState.NO_ROOM_AVAILABLE;
import static com.spring.test.ds.BookingResult.BookingState.ROOM_BOOKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ApplicationServiceIntegrationTest {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private GuestRegistrationService guestRegistrationService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    private static final LocalDate date = LocalDate.of(2025, 7, 20);


    @Test
    public void shouldBookRoomForAfterConfirmingRoomAvailabilityAndRegisteringGuest() {
        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P", "S", date);

        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isNotEmpty();
        assertTrue(guestRepository.existsById(1));
    }


    @Test
    @DirtiesContext
    public void shouldRejectReservationWhenNoRoom() {
        roomRepository.deleteAll();

        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P", "S", LocalDate.of(2020, 7, 20));

        assertEquals(NO_ROOM_AVAILABLE,bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isEmpty();
        assertThat(guestRepository.findAll()).isEmpty();
    }

    @Test
    @DirtiesContext
    public void shouldRegisterGuest() {
        Guest registeredGuest = applicationService.registerGuest("P","S");

        assertEquals(new Guest(1, "P", "S"), registeredGuest);
        assertThat(guestRepository.findById(1)).isNotEmpty();
    }


    @Test
    @DirtiesContext
    public void shouldBookRoomForRegisteredGuest() {
        Guest guest = applicationService.registerGuest("P","S");

        BookingResult bookingResult = applicationService.bookAnyRoomForRegisteredGuest(guest, date);
        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isNotEmpty();

    }

    @Test
    @DirtiesContext
    public void shouldBookSpecificRoom() {
        Guest guest = applicationService.registerGuest("P","S");
        BookingResult bookingResult = applicationService.bookSpecificRoomForRegisteredGuest(guest, "Yellow Room", date);

        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isNotEmpty();
        assertEquals("Yellow Room", bookingResult.getReservation().orElseThrow().getRoom().getName());
        assertEquals(LocalDate.of(2025, 7, 20), bookingResult.getReservation().get().getReservationDate());
    }

    @Test
    @DirtiesContext
    public void shouldRejectWhenNoRoomAvailable() {
        Guest guest = applicationService.registerGuest("P","S");
        roomRepository.deleteAll();
        BookingResult bookingResult = applicationService.bookAnyRoomForRegisteredGuest(guest, date);

        assertEquals(NO_ROOM_AVAILABLE,bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isEmpty();
    }


    @Test
    @DirtiesContext
    public void shouldRejectWhenAllRoomsAreBooked() {
        applicationService.bookAnyRoomForNewGuest("P", "S", date);
        applicationService.bookAnyRoomForNewGuest("H", "S", date);
        applicationService.bookAnyRoomForNewGuest("R", "S", date);

        Guest guest = applicationService.registerGuest("K","S");

        BookingResult bookingResult = applicationService.bookAnyRoomForRegisteredGuest(guest, date);
        BookingResult bookingResult1 = applicationService.bookSpecificRoomForRegisteredGuest(guest, "Green Room", date);
        BookingResult bookingResult2 = applicationService.bookAnyRoomForRegisteredGuest(guest, LocalDate.of(2025, 7, 10));

        assertEquals(NO_ROOM_AVAILABLE,bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isEmpty();

        assertEquals(NO_ROOM_AVAILABLE,bookingResult1.getBookingState());
        assertThat(bookingResult1.getReservation()).isEmpty();

        assertEquals(ROOM_BOOKED, bookingResult2.getBookingState());
        assertThat(bookingResult2.getReservation()).isNotEmpty();
        assertEquals(LocalDate.of(2025, 7, 10), bookingResult2.getReservation().get().getReservationDate());
        assertEquals("K", bookingResult2.getReservation().get().getGuest().getFirstName());



    }



}