package com.ureca.idle.batch.submissionhistory.reader;

import com.ureca.idle.batch.submissionhistory.TimeUtils;
import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class CurrentSubmissionHistoryItemReader {

    private final EntityManagerFactory entityManagerFactory;
    private final TimeUtils timeUtils;

    public JpaPagingItemReader<CurrentRoundSubmission> currentSubmissionHistoryItemReader() {
        String startTimeStr = timeUtils.getStartTime();
        String endTimeStr = timeUtils.getEndTime();

        String queryString = "SELECT crs FROM CurrentRoundSubmission crs " +
                "WHERE crs.timeStamp >= :startTime AND crs.timeStamp <= :endTime";

        return new JpaPagingItemReaderBuilder<CurrentRoundSubmission>()
                .name("currentSubmissionHistoryItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString(queryString)
                .parameterValues(Map.of("startTime", startTimeStr, "endTime", endTimeStr))
                .pageSize(50)
                .build();
    }
}
