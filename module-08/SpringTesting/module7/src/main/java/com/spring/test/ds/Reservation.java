package com.spring.test.ds;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"room_id", "reservationDate"})})
public class Reservation {
    @Id
    @GeneratedValue
    Integer id;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    private Guest guest;
    private LocalDate reservationDate;

    @SuppressWarnings("unused")
    Reservation() {
    }

    public Reservation(Room room, Guest guest, LocalDate reservationDate) {
        this.room = room;
        this.guest = guest;
        this.reservationDate = reservationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reservation that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRoom(), that.getRoom()) && Objects.equals(getGuest(), that.getGuest()) && Objects.equals(getReservationDate(), that.getReservationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoom(), getGuest(), getReservationDate());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room=" + room +
                ", guest=" + guest +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
