package com.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GuestSharableDataService {

    @Autowired
    private GuestRegistrationService guestRegistrationService;

    public String getGuestSharableData() {
        return guestRegistrationService.listGuests().stream()
                .map(guest -> guest.getFirstName() + " " + guest.getLastName())
                .collect(Collectors.joining(", "));
    }
}
