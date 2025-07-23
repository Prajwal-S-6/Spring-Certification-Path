package com.spring.test.application;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test.ds.Guest;
import com.spring.test.service.GuestRegistrationService;
import com.spring.test.service.HotelManagementService;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ApplicationServiceIntegrationTest  {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private GuestRegistrationService guestRegistrationService;

    @Autowired
    private HotelManagementService hotelManagementService;


    @Test
    @Transactional
    public void shouldRegisterGuest() {
        applicationService.registerGuests(new Guest("P", "S"), new Guest("H", "S"));

        assertThat(applicationService.listGuests().stream().map(Guest::getFirstName).collect(Collectors.toSet())).containsAll(Arrays.asList("P","H"));
    }



}