package com.spring.test.ds;



import java.time.LocalDate;
import java.util.Objects;


public class BookingRequest {
    private Guest guest;
    private LocalDate bookingDate;

    @SuppressWarnings("unused")
    BookingRequest() {
    }

    public BookingRequest(Guest guest, LocalDate bookingDate) {
        this.guest = guest;
        this.bookingDate = bookingDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookingRequest that)) return false;
        return Objects.equals(getGuest(), that.getGuest()) && Objects.equals(getBookingDate(), that.getBookingDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuest(), getBookingDate());
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "guest=" + guest +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
