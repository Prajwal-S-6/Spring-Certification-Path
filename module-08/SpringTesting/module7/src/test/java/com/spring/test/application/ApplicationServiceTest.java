package com.spring.test.application;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test.ds.BookingResult;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Room;
import com.spring.test.repository.RoomRepository;
import com.spring.test.service.BookingService;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.GuestSharableDataService;
import com.spring.test.service.HotelManagementService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.spring.test.configuration.TestDataConfiguration.*;
import static com.spring.test.ds.BookingResult.BookingState.ROOM_BOOKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@ActiveProfiles("test")
public class ApplicationServiceTest  {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private GuestRegistrationService guestRegistrationService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private HotelManagementService hotelManagementService;
    @Autowired
    private GuestSharableDataService guestSharableDataServiceMock;


    private static final LocalDate date = LocalDate.of(2025, 7, 22);

    @Test
    public void shouldContainRoomsFromTestDataConfig() {
        Set<Room> rooms = hotelManagementService.listRooms();

        assertThat(rooms.stream().map(Room::getName).collect(Collectors.toSet())).containsExactlyInAnyOrder(ROOM_A,ROOM_B,ROOM_C);
    }

    @Test
    @Sql("/test-data-guests.sql")
    public void shouldRegisterGuestFromScript() {
        List<Guest> guests = guestRegistrationService.listGuests();
        assertThat(guests).containsOnly(new Guest(1,"P","S"), new Guest(2,"H", "S"), new Guest(3, "G", "K"));
    }

    @Test
    @DirtiesContext
    public void shouldRegisterGuest() {
        Guest registeredGuest = applicationService.registerGuest("P","S");

        assertThat(guestRegistrationService.listGuests()).isNotEmpty();
        assertThat(guestRegistrationService.listGuests()).contains(registeredGuest);
    }

    @Test
    @DirtiesContext
    public void shouldGetGuestSharableData() {
        when(guestSharableDataServiceMock.getGuestSharableData()).thenReturn("PS, HS, GK");

        String data = guestSharableDataServiceMock.getGuestSharableData();

        assertEquals("PS, HS, GK", data);
    }

    @Test
    public void shouldBookAnyRoomForNewGuest() {
        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P","S", date);

        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
        assertNotNull(bookingResult.getReservation().get().getGuest().getId());
        assertEquals("P", bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals("S", bookingResult.getReservation().get().getGuest().getLastName());

    }



}