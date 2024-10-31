package com.ureca.idle.batch.kidspersonalitydeletehistory.config;

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
public class DeleteKidsJobConfiguration {

    @Bean
    public Job deleteBatchJob(Step deleteBatchStep, JobRepository jobRepository) throws Exception {
        System.out.println("Delete Job Start");
        return new JobBuilder("deleteKidsPersonalityBatchJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(deleteBatchStep)
                .build();
    }
}
