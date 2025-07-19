package com.spring.boot.custom.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomUnknownHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.unknown().withDetail("system-status-unknown", true).build();
    }
}
