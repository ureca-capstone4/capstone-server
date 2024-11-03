package com.ureca.idle.batch.submissionhistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class TimeUtils {

    private final FcfsEventPropertiesForBatch fcfsEventPropertiesForBatch;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String getStartTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime = now.minusDays(1)
                .withHour(fcfsEventPropertiesForBatch.getStartTime().getHour())
                .withMinute(fcfsEventPropertiesForBatch.getStartTime().getMinute())
                .withSecond(fcfsEventPropertiesForBatch.getStartTime().getSecond());
        return startTime.format(FORMATTER);
    }

    public String getEndTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endTime = now
                .withHour(fcfsEventPropertiesForBatch.getEndTime().getHour())
                .withMinute(fcfsEventPropertiesForBatch.getEndTime().getMinute())
                .withSecond(fcfsEventPropertiesForBatch.getEndTime().getSecond());
        return endTime.format(FORMATTER);
    }
}
