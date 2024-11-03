package ureca.idlebatch.deletedkidspersonalityhistory.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class DeleteDeletedKidsPersonalityJobConfiguration {

    private final DeleteDeletedKidsPersonalityStepConfiguration deleteDeletedKidsPersonalityStepConfiguration;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;


    public Job deleteKidsPersonalityBatchJob() throws Exception {
        return new JobBuilder("deleteKidsPersonalityBatchJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(deleteDeletedKidsPersonalityStepConfiguration.deleteBatchStep(jobRepository, platformTransactionManager))
                .build();
    }
}
