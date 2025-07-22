package com.spring.test.repository;

import com.spring.test.ds.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    Set<Room> findAll();

    Optional<Room> findByName(String name);
}
