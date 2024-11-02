package com.ureca.idle.batch.deletedkidspersonalityhistory.config;

import com.ureca.idle.batch.deletedkidspersonalityhistory.reader.DeletedKidsPersonalityHistoryItemReader;
import com.ureca.idle.batch.deletedkidspersonalityhistory.writer.DeleteDeletedKidsPersonalityHistoryItemWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class DeleteDeletedKidsPersonalityStepConfiguration {

    private final DeletedKidsPersonalityHistoryItemReader deletedKidsPersonalityHistoryItemReader;
    private final DeleteDeletedKidsPersonalityHistoryItemWriter deleteDeletedKidsPersonalityHistoryItemWriter;


    public Step deleteBatchStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
        return new StepBuilder("deleteBatchStep", jobRepository)
                .<Long, Long>chunk(10, transactionManager)
                .reader(deletedKidsPersonalityHistoryItemReader.deleteItemReader())
                .writer(deleteDeletedKidsPersonalityHistoryItemWriter.deleteItemWriter())
                .build();
    }
}
