package com.spring.test.configuration;

import com.spring.test.service.GuestSharableDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Configuration
public class TestConfiguration {

    @Bean
    @Profile("test")
    public GuestSharableDataService testGuestSharableDataService() {
        return mock(GuestSharableDataService.class);
    }
}
