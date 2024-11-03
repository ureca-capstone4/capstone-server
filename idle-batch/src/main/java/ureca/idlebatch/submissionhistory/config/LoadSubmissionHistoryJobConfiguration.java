package ureca.idlebatch.submissionhistory.config;

import com.ureca.idle.batch.submissionhistory.JobTimeLoggingListener;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class LoadSubmissionHistoryJobConfiguration {

    private final LoadSubmissionHistoryStepConfiguration loadSubmissionHistoryStepConfiguration;
    private final JobRepository jobRepository;
    private final JobTimeLoggingListener jobTimeLoggingListener;
    private final PlatformTransactionManager transactionManager;

    public Job updateSubmissionHistoryJob() {
        return new JobBuilder("updateSubmissionHistoryJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(jobTimeLoggingListener)
                .start(loadSubmissionHistoryStepConfiguration.processCurrentSubmissionHistoryStep(jobRepository, transactionManager))
                .next(loadSubmissionHistoryStepConfiguration.deleteCurrentSubmissionHistoryStep(jobRepository, transactionManager))
                .build();
    }
}
