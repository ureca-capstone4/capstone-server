package com.ureca.idle.batch.kidspersonalitybatch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SaveKidsJobConfiguration {

    private final Step saveKidsPersonalityStep;

    @Bean
    public Job saveKidsPersonalityJob(JobRepository jobRepository) {
        return new JobBuilder("saveKidsPersonalityJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(saveKidsPersonalityStep)
                .build();
    }
}
