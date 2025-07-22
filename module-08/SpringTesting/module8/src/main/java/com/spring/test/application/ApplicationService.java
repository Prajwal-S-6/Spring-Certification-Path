package com.spring.test.application;


import com.spring.test.ds.Guest;
import com.spring.test.ds.Room;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.GuestSharableDataService;
import com.spring.test.service.HotelManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ApplicationService {

    @Autowired
    private GuestRegistrationService guestRegistrationService;
    @Autowired
    private HotelManagementService hotelManagementService;
    @Autowired
    private GuestSharableDataService guestSharableDataService;

    public Set<Room> listRooms() {
        return hotelManagementService.listRooms();
    }

    public List<Guest> listGuests() {
        return guestRegistrationService.listGuests();
    }

    public String getGuestSharableData() {
        return guestSharableDataService.getGuestSharableData();
    }
}
