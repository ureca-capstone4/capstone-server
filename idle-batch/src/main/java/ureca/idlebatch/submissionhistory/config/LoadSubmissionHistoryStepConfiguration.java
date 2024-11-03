package ureca.idlebatch.submissionhistory.config;

import com.ureca.idle.batch.submissionhistory.reader.CurrentSubmissionHistoryItemReader;
import com.ureca.idle.batch.submissionhistory.tasklet.DeleteCurrentSubmissionHistoryTasklet;
import com.ureca.idle.batch.submissionhistory.writer.TransferSubmissionHistoryWriter;
import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class LoadSubmissionHistoryStepConfiguration {

    private final CurrentSubmissionHistoryItemReader currentSubmissionHistoryItemReader;
    private final TransferSubmissionHistoryWriter transferSubmissionHistoryWriter;
    private final DeleteCurrentSubmissionHistoryTasklet deleteCurrentSubmissionHistoryTasklet;

    public Step processCurrentSubmissionHistoryStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("saveSubmissionHistoryStep", jobRepository)
                .<CurrentRoundSubmission, CurrentRoundSubmission>chunk(50,transactionManager)
                .reader(currentSubmissionHistoryItemReader.currentSubmissionHistoryItemReader())
                .writer(transferSubmissionHistoryWriter)
                .build();
    }

    public Step deleteCurrentSubmissionHistoryStep(
            JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("deleteCurrentSubmissionHistoryStep", jobRepository)
                .tasklet(deleteCurrentSubmissionHistoryTasklet, transactionManager)
                .build();
    }
}
