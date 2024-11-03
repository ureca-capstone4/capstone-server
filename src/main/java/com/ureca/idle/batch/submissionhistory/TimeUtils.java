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
        LocalDateTime startTime = now.minusDays(1).withHour(Integer.parseInt(fcfsEventPropertiesForBatch.getStartTime().split(":")[0]))
                .withMinute(Integer.parseInt(fcfsEventPropertiesForBatch.getStartTime().split(":")[1]))
                .withSecond(Integer.parseInt(fcfsEventPropertiesForBatch.getStartTime().split(":")[2]));
        return startTime.format(FORMATTER);
    }

    public String getEndTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endTime = now.withHour(Integer.parseInt(fcfsEventPropertiesForBatch.getEndTime().split(":")[0]))
                .withMinute(Integer.parseInt(fcfsEventPropertiesForBatch.getEndTime().split(":")[1]))
                .withSecond(Integer.parseInt(fcfsEventPropertiesForBatch.getEndTime().split(":")[2]));
        return endTime.format(FORMATTER);
    }
}
