package com.spring.test.application;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test.ds.Guest;
import com.spring.test.ds.Room;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.HotelManagementService;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@Transactional
public class ApplicationServiceIntegrationTest  {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private GuestRegistrationService guestRegistrationService;

    @Autowired
    private HotelManagementService hotelManagementService;


    @Test
//    @Commit
    public void shouldRegisterGuest() {
        applicationService.registerGuests(new Guest("P", "S"), new Guest("H", "S"));

        assertThat(applicationService.listGuests().stream().map(Guest::getFirstName).collect(Collectors.toSet())).containsAll(Arrays.asList("P","H"));
    }


    @Test
//    @Rollback(value = false)
    public void shouldRegisterRoom() {
        applicationService.registerRooms(new Room("A", "A"),new Room("B", "B"));

        assertThat(applicationService.listRooms().stream().map(Room::getName).collect(Collectors.toSet())).containsAll(Arrays.asList("A","B"));


    }





}