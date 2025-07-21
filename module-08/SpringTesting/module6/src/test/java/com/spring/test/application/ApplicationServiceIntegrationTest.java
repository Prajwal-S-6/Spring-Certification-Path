package com.spring.test.application;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test.ds.BookingResult;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Reservation;
import com.spring.test.ds.Room;
import com.spring.test.repository.GuestRepository;
import com.spring.test.repository.RoomRepository;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static com.spring.test.ds.BookingResult.BookingState.NO_ROOM_AVAILABLE;
import static com.spring.test.ds.BookingResult.BookingState.ROOM_BOOKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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

    private static final LocalDate date = LocalDate.of(2025, 7, 20);


    @Test
    public void shouldBookRoomForAfterConfirmingRoomAvailabilityAndRegisteringGuest() {
        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P", "S", date);

        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isNotEmpty();
    }


    @Test
    public void shouldRejectReservationWhenNoRoom() {
        roomRepository.deleteAll();

        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P", "S", LocalDate.of(2020, 7, 20));

        assertEquals(NO_ROOM_AVAILABLE,bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isEmpty();
    }

    @Test
    public void shouldRegisterGuest() {
        Guest registeredGuest = applicationService.registerGuest("P","S");

        assertEquals(new Guest(1, "P", "S"), registeredGuest);
        assertThat(guestRepository.findById(1)).isNotEmpty();
    }





}