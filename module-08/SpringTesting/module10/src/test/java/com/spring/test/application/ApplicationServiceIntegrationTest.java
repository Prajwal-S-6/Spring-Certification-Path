package com.spring.test.application;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test.ds.BookingResult;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Room;
import com.spring.test.repository.RoomRepository;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static com.spring.test.configuration.TestDataCofiguration.*;
import static com.spring.test.ds.BookingResult.BookingState.NO_ROOM_AVAILABLE;
import static com.spring.test.ds.BookingResult.BookingState.ROOM_BOOKED;
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

    @Autowired
    private RoomRepository roomRepository;

    private static final LocalDate date = LocalDate.of(2025, 7, 24);

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
    @DirtiesContext
    public void shouldRegisterGuest() {
        Guest registered = applicationService.registerGuest("P","S");

        assertThat(guestRegistrationService.listGuests().stream().map(Guest::getId).toList()).isNotEmpty();
        assertNotNull(registered.getId());
        assertEquals("P",registered.getFirstName());
        assertEquals("S", registered.getLastName());
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

    @Test
    @DirtiesContext
    public void shouldBookAnyRoomForRegisteredGuest() {
        Guest registered = applicationService.registerGuest("P","S");

        BookingResult bookingResult = applicationService.bookAnyRoomForRegisteredGuest(registered, date);
        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isPresent();
        assertEquals(registered.getFirstName(),bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals(registered.getLastName(),bookingResult.getReservation().get().getGuest().getLastName());
        assertThat(roomRepository.findAll().stream().map(Room::getName).collect(Collectors.toSet())).contains(bookingResult.getReservation().get().getRoom().getName());
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
    }

    @Test
    @DirtiesContext
    public void shouldBookSpecificRoomForRegisteredGuest() {
        Guest registered = applicationService.registerGuest("P","S");

        BookingResult bookingResult = applicationService.bookSpecificRoomForRegisteredGuest(registered, ROOM_A, date);
        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isPresent();
        assertEquals(registered.getFirstName(),bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals(registered.getLastName(),bookingResult.getReservation().get().getGuest().getLastName());
        assertEquals(ROOM_A, bookingResult.getReservation().get().getRoom().getName());
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
    }

    @Test
    @DirtiesContext
    public void shouldNotBookRoomAndNotRegisterNewGuestWhenNoRoomIsAvailable() {
        roomRepository.deleteAll();

        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P","S", date);

        assertEquals(NO_ROOM_AVAILABLE, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isEmpty();
    }

    @Test
    @DirtiesContext
    public void shouldNotBookRoomWhenAllRoomsAreBooked() {
        Guest guest1 = applicationService.registerGuest("P","S");
        Guest guest2 = applicationService.registerGuest("H","S");
        Guest guest3 = applicationService.registerGuest("G","K");


        applicationService.bookSpecificRoomForRegisteredGuest(guest1, ROOM_A, date);
        applicationService.bookSpecificRoomForRegisteredGuest(guest2, ROOM_B, date);
        applicationService.bookSpecificRoomForRegisteredGuest(guest3, ROOM_C, date);

        BookingResult bookingResult = applicationService.bookAnyRoomForRegisteredGuest(guest1, date);
        assertEquals(NO_ROOM_AVAILABLE, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isEmpty();
    }
}