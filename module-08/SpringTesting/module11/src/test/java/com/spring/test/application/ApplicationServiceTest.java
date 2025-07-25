package com.spring.test.application;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test.ds.BookingResult;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Room;
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
import java.util.stream.Collectors;

import static com.spring.test.ds.BookingResult.BookingState.ROOM_BOOKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private GuestRegistrationService guestRegistrationService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomRepository roomRepository;

    private static final LocalDate date = LocalDate.of(2025, 7, 25);

    @Test
    @DirtiesContext
    public void shouldRegisterGuest() {
        Guest registeredGuest = applicationService.registerGuest("P","S");

        assertThat(registeredGuest.getId()).isNotNull();
        assertEquals("P", registeredGuest.getFirstName());
        assertEquals("S", registeredGuest.getLastName());
        assertThat(guestRegistrationService.listGuests().stream().map(Guest::getFirstName)).containsOnly("P");

    }

    @Test
    @DirtiesContext
    public void shouldBookAnyRoomForNewGuest() {
        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P","S", date);


        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isPresent();
        assertThat(bookingResult.getReservation().get().getGuest().getId()).isNotNull();
        assertThat(guestRegistrationService.listGuests().stream().map(Guest::getFirstName)).contains("P");
        assertEquals("P",bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals("S",bookingResult.getReservation().get().getGuest().getLastName());
        assertThat(roomRepository.findAll().stream().map(Room::getName).collect(Collectors.toSet())).contains(bookingResult.getReservation().get().getRoom().getName());
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
    }

}