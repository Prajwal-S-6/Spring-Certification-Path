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
import static com.spring.test.ds.BookingResult.BookingState.NO_ROOM_AVAILABLE;
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
    private RoomRepository roomRepository;

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
    @DirtiesContext
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
    @DirtiesContext
    public void shouldBookAnyRoomForNewGuest() {
        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P","S", date);

        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
        assertNotNull(bookingResult.getReservation().get().getGuest().getId());
        assertEquals("P", bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals("S", bookingResult.getReservation().get().getGuest().getLastName());

    }

    @Test
    @DirtiesContext
    public void shouldRejectWhenNoRoomIsAvailable() {
        roomRepository.deleteAll();

        BookingResult bookingResult = applicationService.bookAnyRoomForNewGuest("P","S", date);

        assertEquals(NO_ROOM_AVAILABLE, bookingResult.getBookingState());
        assertThat(bookingResult.getReservation()).isEmpty();
    }


    @Test
    @DirtiesContext
    public void shouldBookAnyRoomForRegisteredGuest() {
        Guest guest = applicationService.registerGuest("P", "S");

        BookingResult bookingResult = applicationService.bookAnyRoomForRegisteredGuest(guest, date);

        assertEquals(ROOM_BOOKED, bookingResult.getBookingState());
        assertEquals(date, bookingResult.getReservation().get().getReservationDate());
        assertNotNull(bookingResult.getReservation().get().getGuest().getId());
        assertEquals(guest.getFirstName(), bookingResult.getReservation().get().getGuest().getFirstName());
        assertEquals(guest.getLastName(), bookingResult.getReservation().get().getGuest().getLastName());
        assertThat(hotelManagementService.listRooms()).contains(bookingResult.getReservation().get().getRoom());
    }

    @Test
    @DirtiesContext
    public void shouldRejectWhenAllRoomsAreBooked() {
        Guest guest1 = applicationService.registerGuest("P", "S");
        Guest guest2 = applicationService.registerGuest("H", "S");
        Guest guest3 = applicationService.registerGuest("G", "K");

        BookingResult bookingResult1 = applicationService.bookSpecificRoomForRegisteredGuest(guest1, ROOM_C, date);
        BookingResult bookingResult2 = applicationService.bookSpecificRoomForRegisteredGuest(guest2, ROOM_B, date);
        BookingResult bookingResult3 = applicationService.bookSpecificRoomForRegisteredGuest(guest3, ROOM_A, date);

        assertEquals(ROOM_BOOKED, bookingResult1.getBookingState());
        assertThat(bookingResult1.getReservation()).isPresent();
        assertEquals(ROOM_C, bookingResult1.getReservation().get().getRoom().getName());
        assertEquals(guest1.getFirstName(), bookingResult1.getReservation().get().getGuest().getFirstName());
        assertEquals(guest1.getLastName(), bookingResult1.getReservation().get().getGuest().getLastName());

        assertEquals(ROOM_BOOKED, bookingResult2.getBookingState());
        assertThat(bookingResult2.getReservation()).isPresent();
        assertEquals(ROOM_B, bookingResult2.getReservation().get().getRoom().getName());
        assertEquals(guest2.getFirstName(), bookingResult2.getReservation().get().getGuest().getFirstName());
        assertEquals(guest2.getLastName(), bookingResult2.getReservation().get().getGuest().getLastName());

        assertEquals(ROOM_BOOKED, bookingResult3.getBookingState());
        assertThat(bookingResult3.getReservation()).isPresent();
        assertEquals(ROOM_A, bookingResult3.getReservation().get().getRoom().getName());
        assertEquals(guest3.getFirstName(), bookingResult3.getReservation().get().getGuest().getFirstName());
        assertEquals(guest3.getLastName(), bookingResult3.getReservation().get().getGuest().getLastName());


        BookingResult bookingResult4 = applicationService.bookAnyRoomForRegisteredGuest(guest1, date);
        BookingResult bookingResult5 = applicationService.bookAnyRoomForNewGuest("P", "S", date);

        assertEquals(NO_ROOM_AVAILABLE, bookingResult4.getBookingState());
        assertEquals(NO_ROOM_AVAILABLE, bookingResult5.getBookingState());
        assertThat(bookingResult4.getReservation()).isEmpty();
        assertThat(bookingResult5.getReservation()).isEmpty();
    }





}