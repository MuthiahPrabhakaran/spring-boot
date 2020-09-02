package io.mp.todoapp.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MaxMemoryHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        //For demo purpose, we are checking with 100MB
        boolean invalid = Runtime.getRuntime().maxMemory() < (1024 * 100 * 100);
        Status status = invalid? Status.DOWN : Status.UP;
        return Health.status(status).build();
    }
}
