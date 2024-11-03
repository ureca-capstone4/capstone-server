package com.ureca.idle.batch.submissionhistory;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "event.fcfs")
public class FcfsEventPropertiesForBatch {
    private String startTime;
    private String endTime;
}
