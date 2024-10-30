package com.ureca.idle.batch.kidsPersonalityDeleteHistory;

import com.ureca.idle.batch.dto.KidsPersonalityDeleteHistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class DeleteKidsStepConfiguration {

    private final JdbcPagingItemReader<KidsPersonalityDeleteHistoryDto> deleteItemReader;
    private final JdbcBatchItemWriter<Long> deleteItemWriter;
    @Bean
    public Step deleteBatchStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        return new StepBuilder("deleteBatchStep", jobRepository)
                .<KidsPersonalityDeleteHistoryDto, Long>chunk(10, transactionManager)
                .reader(deleteItemReader)
                .writer(deleteItemWriter)
                .build();
    }
}
