package com.ureca.idle.batch.submissionhistory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getStartTime() {
        LocalDateTime startTime = LocalDateTime.now().minusDays(1).withHour(13).withMinute(0).withSecond(0);
        return startTime.format(FORMATTER);
    }

    public static String getEndTime() {
        LocalDateTime endTime = LocalDateTime.now().withHour(12).withMinute(59).withSecond(59);
        return endTime.format(FORMATTER);
    }
}
