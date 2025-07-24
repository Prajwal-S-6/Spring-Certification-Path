package com.spring.test.configuration;

import com.spring.test.service.GuestSharableDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfiguration {

    @Bean
    public GuestSharableDataService guestSharableDataService() {
        return mock(GuestSharableDataService.class);
    }
}
