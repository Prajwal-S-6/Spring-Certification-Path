package com.spring.test.application;

import com.spring.test.context.aproach1.IntegrationTestBase;
import com.spring.test.ds.Room;
import com.spring.test.service.GuestSharableDataService;
import com.spring.test.service.HotelManagementService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

import static com.spring.test.configuration.TestDataConfiguration.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplicationServiceIntegrationTest1 extends IntegrationTestBase {

    @Autowired
    private HotelManagementService hotelManagementService;

    @Autowired
    private GuestSharableDataService guestSharableDataServiceMock;

    @Test
    public void shouldGetListOfRooms() {
       Set<Room> roomSet = hotelManagementService.listRooms();

       assertThat(roomSet.stream().map(Room::getName).collect(Collectors.toSet())).containsExactlyInAnyOrder(ROOM_A, ROOM_B, ROOM_C);

       when(guestSharableDataServiceMock.getGuestSharableData()).thenReturn("PS, HS");
    }
}