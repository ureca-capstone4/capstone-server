package com.ureca.idle.batch.kidspersonalityhistory.config;

import com.ureca.idle.batch.kidspersonalityhistory.dto.ChangedKidsPersonalityHistoryResp;
import com.ureca.idle.batch.kidspersonalityhistory.reader.KidReader;
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
public class SaveKidsPersonalityInHistoryStepConfiguration {

    private final KidReader kidReader;
    private final ItemProcessor<Long, ChangedKidsPersonalityHistoryResp> KidsPersonalityProcessor;
    private final ItemWriter<ChangedKidsPersonalityHistoryResp> SaveKidsPersonalityInHistoryWriter;

    public Step saveKidsPersonalityInHistoryStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("saveKidsPersonalityStep", jobRepository)
                .<Long, ChangedKidsPersonalityHistoryResp>chunk(50, transactionManager)
                .reader(kidReader.kidItemReader())
                .processor(KidsPersonalityProcessor)
                .writer(SaveKidsPersonalityInHistoryWriter)
                .build();
    }
}
