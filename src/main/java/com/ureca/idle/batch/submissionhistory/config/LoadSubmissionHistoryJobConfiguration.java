package com.ureca.idle.batch.submissionhistory.config;

import com.ureca.idle.batch.submissionhistory.JobTimeLoggingListener;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LoadSubmissionHistoryJobConfiguration {

    private final Step deletePreviousSubmissionHistoryStep;
    private final Step loadCurrentSubmissionHistoryStep;
    private final Step deleteCurrentSubmissionHistoryStep;
    private final JobTimeLoggingListener jobTimeLoggingListener;

    @Bean
    public Job loadSubmissionHistoryJob(JobRepository jobRepository) {
        return new JobBuilder("saveSubmissionHistoryJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(jobTimeLoggingListener) // JobExecutionListener 등록
                .start(deletePreviousSubmissionHistoryStep)
                .next(loadCurrentSubmissionHistoryStep)
                .next(deleteCurrentSubmissionHistoryStep)
                .build();
    }
}
