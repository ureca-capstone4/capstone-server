package com.ureca.idle.batch.submissionhistory.config;

import com.ureca.idle.batch.submissionhistory.JobTimeLoggingListener;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;

import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LoadSubmissionHistoryJobConfiguration {

    private final Step deletePreviousSubmissionHistoryStep;
    private final Step processCurrentSubmissionHistoryStep;
    private final Step deleteCurrentSubmissionHistoryStep;
    private final JobRepository jobRepository;
    private final JobTimeLoggingListener jobTimeLoggingListener;

    public Job updateSubmissionHistoryJob() {
        return new JobBuilder("updateSubmissionHistoryJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(jobTimeLoggingListener)
                .start(deletePreviousSubmissionHistoryStep)
                .next(processCurrentSubmissionHistoryStep)
                .next(deleteCurrentSubmissionHistoryStep)
                .build();
    }
}
