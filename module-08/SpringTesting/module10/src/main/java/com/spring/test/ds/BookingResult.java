package com.spring.test.ds;



import java.util.Objects;
import java.util.Optional;


public class BookingResult {
    private BookingState bookingState;
    private Reservation reservation;

    public static BookingResult createRoomBookedResult(Reservation reservation) {
        return new BookingResult(BookingState.ROOM_BOOKED, reservation);
    }

    public static BookingResult createNoRoomAvailableResult() {
        return new BookingResult(BookingState.NO_ROOM_AVAILABLE, null);
    }

    private BookingResult(BookingState bookingState, Reservation reservation) {
        this.bookingState = bookingState;
        this.reservation = reservation;
    }

    public BookingState getBookingState() {
        return bookingState;
    }

    public Optional<Reservation> getReservation() {
        return Optional.ofNullable(reservation);
    }

    public enum BookingState {
        ROOM_BOOKED,
        NO_ROOM_AVAILABLE
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookingResult that)) return false;
        return getBookingState() == that.getBookingState() && Objects.equals(getReservation(), that.getReservation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingState(), getReservation());
    }
}
