package com.spring.test.repository;



import com.spring.test.ds.Reservation;
import com.spring.test.ds.Room;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public interface ReservationRepository extends CrudRepository<Reservation, UUID> {

    Set<Reservation> findAllByReservationDate(LocalDate reservationDate);

    boolean existsByRoomAndReservationDate(Room room, LocalDate reservationDate);
}
