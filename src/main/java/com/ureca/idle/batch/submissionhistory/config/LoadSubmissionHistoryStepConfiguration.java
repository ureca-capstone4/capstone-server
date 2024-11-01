package com.ureca.idle.batch.submissionhistory.config;

import com.ureca.idle.batch.submissionhistory.reader.CurrentSubmissionHistoryItemReader;
import com.ureca.idle.batch.submissionhistory.writer.TransferSubmissionHistoryWriter;
import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class LoadSubmissionHistoryStepConfiguration {

    private final CurrentSubmissionHistoryItemReader currentSubmissionHistoryItemReader;
    private final TransferSubmissionHistoryWriter transferSubmissionHistoryWriter;

    @Bean
    public Step processCurrentSubmissionHistoryStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("saveSubmissionHistoryStep", jobRepository)
                .<CurrentRoundSubmission, CurrentRoundSubmission>chunk(50,transactionManager)
                .reader(currentSubmissionHistoryItemReader.currentSubmissionHistoryItemReader())
                .writer(transferSubmissionHistoryWriter)
                .build();
    }

    @Bean
    public Step deletePreviousSubmissionHistoryStep(
            JobRepository jobRepository, PlatformTransactionManager transactionManager,
            @Qualifier("deletePreviousSubmissionHistoryTasklet") Tasklet DeletePreviousSubmissionHistoryTasklet) {
        return new StepBuilder("deletePreviousSubmissionHistoryStep", jobRepository)
                .tasklet(DeletePreviousSubmissionHistoryTasklet, transactionManager)
                .build();
    }

    @Bean
    public Step deleteCurrentSubmissionHistoryStep(
            JobRepository jobRepository, PlatformTransactionManager transactionManager,
            @Qualifier("deleteCurrentSubmissionHistoryTasklet") Tasklet DeleteCurrentRoundSubmissionHistoryTasklet) {
        return new StepBuilder("deleteCurrentSubmissionHistoryStep", jobRepository)
                .tasklet(DeleteCurrentRoundSubmissionHistoryTasklet, transactionManager)
                .build();
    }
}
