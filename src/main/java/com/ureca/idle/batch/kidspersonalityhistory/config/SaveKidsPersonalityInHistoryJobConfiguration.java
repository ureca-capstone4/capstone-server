package com.ureca.idle.batch.kidspersonalityhistory.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class SaveKidsPersonalityInHistoryJobConfiguration {

    private final SaveKidsPersonalityInHistoryStepConfiguration saveKidsPersonalityInHistoryStepConfiguration;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    public Job saveKidsPersonalityInHistoryJob() {
        return new JobBuilder("saveKidsPersonalityJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(saveKidsPersonalityInHistoryStepConfiguration.saveKidsPersonalityInHistoryStep(jobRepository, platformTransactionManager))
                .build();
    }
}
