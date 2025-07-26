package com.spring.test.application;

import com.spring.test.ds.BookingResult;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Room;
import com.spring.test.repository.RoomRepository;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.GuestSharableDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static com.spring.test.configuration.SampleDataConfiguration.GREEN_ROOM;
import static com.spring.test.ds.BookingResult.BookingState.ROOM_BOOKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private GuestRegistrationService guestRegistrationService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomRepository roomRepository;

    @MockitoBean
    private GuestSharableDataService guestSharableDataService;

    private static final LocalDate date = LocalDate.of(2025, 7, 26);

    @Test
    public void shouldRegisterGuest() {
        Guest registeredGuest = applicationService.registerGuest("P", "S");
        assertThat(registeredGuest.getId()).isNotNull();
        assertEquals("P", registeredGuest.getFirstName());
        assertEquals("S", registeredGuest.getLastName());
        assertThat(guestRegistrationService.listGuests().stream().map(g -> g.getFirstName() + " " + g.getLastName()).toList()).contains("P S");
    }

    @Test
    public void shouldGetGuestSharableData() {
        when(guestSharableDataService.getGuestSharableData()).thenReturn("PS, HS, GK");

        String guestSharableData = applicationService.getGuestSharableData();

        assertThat(guestSharableData).isEqualTo("PS, HS, GK");
    }

    @Test
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
    public void shouldBookSpecificRoomForRegisteredGuest() {
        Guest registered = applicationService.registerGuest("P","S");

        BookingResult bookingResult = applicationService.bookSpecificRoomForRegisteredGuest(registered, GREEN_ROOM, date);
        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isPresent();
        assertEquals(registered.getFirstName(),bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals(registered.getLastName(),bookingResult.getReservation().get().getGuest().getLastName());
        assertEquals(GREEN_ROOM, bookingResult.getReservation().get().getRoom().getName());
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
    }

}