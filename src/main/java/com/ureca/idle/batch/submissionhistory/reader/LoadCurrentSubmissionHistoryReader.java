package com.ureca.idle.batch.submissionhistory.reader;

import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LoadCurrentSubmissionHistoryReader {

    private final EntityManagerFactory entityManagerFactory;

    @Bean
    public JpaPagingItemReader<CurrentRoundSubmission> loadCurrentSubmissionHistoryItemReader() {
        return new JpaPagingItemReaderBuilder<CurrentRoundSubmission>()
                .name("saveSubmissionHistoryItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT crs FROM CurrentRoundSubmission crs")
                .pageSize(10)
                .build();
    }
}