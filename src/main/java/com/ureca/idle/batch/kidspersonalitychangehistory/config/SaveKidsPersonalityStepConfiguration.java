package com.ureca.idle.batch.kidspersonalitychangehistory.config;

import com.ureca.idle.batch.kidspersonalitychangehistory.dto.KidsPersonalityChangeHistoryResp;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SaveKidsPersonalityStepConfiguration {

    private final JpaPagingItemReader<Long> saveKidsItemReader;
    private final ItemProcessor<Long, KidsPersonalityChangeHistoryResp> saveKidsItemProcessor;
    private final ItemWriter<KidsPersonalityChangeHistoryResp> saveKidsItemWriter;

    @Bean
    public Step saveKidsPersonalityStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("saveKidsPersonalityStep", jobRepository)
                .<Long, KidsPersonalityChangeHistoryResp>chunk(10, transactionManager)
                .reader(saveKidsItemReader)
                .processor(saveKidsItemProcessor)
                .writer(saveKidsItemWriter)
                .build();
    }
}
