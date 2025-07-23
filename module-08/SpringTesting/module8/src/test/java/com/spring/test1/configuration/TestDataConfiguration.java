package com.spring.test1.configuration;

import com.spring.test.ds.Room;
import com.spring.test.service.HotelManagementService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDataConfiguration {

    public static final String ROOM_A = "Room A";
    public static final String ROOM_B = "Room B";
    public static final String ROOM_C = "Room C";

    @Autowired
    private HotelManagementService hotelManagementService;


    @PostConstruct
    private void registerRooms() {
        hotelManagementService.registerRoom(new Room( ROOM_A, "A"));
        hotelManagementService.registerRoom(new Room( ROOM_B, "B"));
        hotelManagementService.registerRoom(new Room( ROOM_C, "C"));
    }

}
