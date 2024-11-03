package com.ureca.idle.batch.submissionhistory;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Data
@Component
@ConfigurationProperties(prefix = "event.fcfs")
public class FcfsEventPropertiesForBatch {
    private LocalTime startTime;
    private LocalTime endTime;
}
