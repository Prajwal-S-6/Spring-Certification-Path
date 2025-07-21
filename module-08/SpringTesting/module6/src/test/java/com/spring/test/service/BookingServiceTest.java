package com.spring.test.service;

import com.spring.test.ds.Guest;
import com.spring.test.ds.Reservation;
import com.spring.test.ds.Room;
import com.spring.test.repository.ReservationRepository;
import com.spring.test.repository.RoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static com.spring.test.ds.BookingResult.BookingState.ROOM_BOOKED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest  {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private RoomRepository roomRepository;

    private static final LocalDate date = LocalDate.of(2025,7, 21);

    @Test
    public void shouldFindAvailableRoomsAtDateWithAllRoomsAvailable() {
        Room room1 = new Room("A","A");
        Room room2 = new Room("B","B");
        when(roomRepository.findAll()).thenReturn(Set.of(room1, room2));
        when(reservationRepository.findAllByReservationDate(date)).thenReturn(Set.of());

        Optional<Room> roomAvailable = bookingService.findAvailableRoom(date);

        assertThat(roomAvailable).isPresent();
        assertThat(roomAvailable.get()).isIn(room1,room2);
    }

    @Test
    public void shouldFindRoomWhichIsNotReserved() {
        Room room1 = new Room("A","A");
        Room room2 = new Room("B","B");
        when(roomRepository.findAll()).thenReturn(Set.of(room1, room2));
        when(reservationRepository.findAllByReservationDate(date)).thenReturn(Set.of(new Reservation(room1, new Guest("P","S"),date)));

        Optional<Room> availableRoom = bookingService.findAvailableRoom(date);

        assertEquals(room2, availableRoom.get());
        assertThat(availableRoom.get()).isEqualTo(room2);

    }

    @Test
    public void shouldNotFindRoomWhenAllAreReserved() {
        Room room1 = new Room("A","A");
        Room room2 = new Room("B","B");
        when(roomRepository.findAll()).thenReturn(Set.of(room1, room2));
        when(reservationRepository.findAllByReservationDate(date)).thenReturn(Set.of(new Reservation(room1, new Guest("P","S"),date), new Reservation(room2, new Guest("A", "Z"),date)));

        Optional<Room> room = bookingService.findAvailableRoom(date);

        assertThat(room).isEmpty();

    }

    @Test
    public void shouldNotFindRoomWhenRoomsAreNotAvailable() {
        when(roomRepository.findAll()).thenReturn(Set.of());
        when(reservationRepository.findAllByReservationDate(date)).thenReturn(Set.of());

        Optional<Room> room = bookingService.findAvailableRoom(date);

        assertThat(room).isEmpty();

    }

    @Test
    public void shouldBookByRoomName() {
        when(roomRepository.findByName("A")).thenReturn(Optional.of(new Room("A", "A")));
        when(reservationRepository.existsByRoomAndReservationDate(new Room("A","A"), date)).thenReturn(false);
        when(reservationRepository.save(new Reservation(new Room("A","A"),new Guest("P","S"),date))).thenReturn(new Reservation(new Room("A","A"),new Guest("P","S"),date));

        Optional<Reservation> reservation = bookingService.bookRoom("A", new Guest("P","S"),date);

        assertThat(reservation).isPresent();
        assertEquals(date, reservation.get().getReservationDate());

    }

    @Test()
    public void shouldNotBookIfRoomIsNotAvailableByName() {
        when(roomRepository.findByName("A")).thenThrow(NoSuchElementException.class);
        assertThrows(NoSuchElementException.class, () -> bookingService.bookRoom("A", new Guest("P","S"),date));
    }


}