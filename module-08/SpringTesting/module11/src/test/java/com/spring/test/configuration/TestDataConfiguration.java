package com.spring.test.configuration;

import com.spring.test.ds.Room;
import com.spring.test.repository.RoomRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDataConfiguration {

    @Autowired
    private RoomRepository roomRepository;

    public static final String ROOM_A = "A";
    public static final String ROOM_B = "B";
    public static final String ROOM_C = "C";

    @PostConstruct
    public void registerRoomsInit() {
        roomRepository.save(new Room(ROOM_A, "A"));
        roomRepository.save(new Room(ROOM_B, "B"));
        roomRepository.save(new Room(ROOM_C, "C"));
    }
}
