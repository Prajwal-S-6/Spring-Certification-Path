package com.spring.test.service;

import com.spring.test.ds.Guest;
import com.spring.test.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestRegistrationService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest registerGuest(Guest guest) {
        if (guest.getId() != null)
            throw new IllegalArgumentException(String.format("Guest [%s] already has ID assigned", guest));

        return guestRepository.save(guest);
    }

    public List<Guest> listGuests() {
        return guestRepository.findAll();
    }
}
