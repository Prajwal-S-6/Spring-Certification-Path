package com.spring.mvc.example9.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.TimeZone;

@RestController
public class Type9TimeZoneAndZoneId {

    @GetMapping("/actionI")
    public String actionI(TimeZone timeZone, ZoneId zoneId) {
        return String.format("Retrieved from TimeZone and ZoneId: %s, %s", timeZone.getDisplayName(), zoneId.getId());
    }
}
