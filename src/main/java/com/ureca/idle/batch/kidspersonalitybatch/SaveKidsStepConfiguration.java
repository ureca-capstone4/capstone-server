package com.ureca.idle.batch.kidspersonalitybatch;

import com.ureca.idle.jpa.kid.Kid;
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
public class SaveKidsStepConfiguration {

    private final JpaPagingItemReader<Long> saveKidsItemReader;
    private final ItemProcessor<Long, Kid> saveKidsItemProcessor;
    private final ItemWriter<Kid> saveKidsItemWriter;

    @Bean
    public Step saveKidsPersonalityStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("saveKidsPersonalityStep", jobRepository)
                .<Long, Kid>chunk(10, transactionManager)
                .reader(saveKidsItemReader)
                .processor(saveKidsItemProcessor)
                .writer(saveKidsItemWriter)
                .build();
    }
}
