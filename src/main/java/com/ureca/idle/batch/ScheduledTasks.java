package com.ureca.idle.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class ScheduledTasks {

    private final JobLauncher jobLauncher;

    private final Job saveKidsPersonalityJob;

    private final Job deleteBatchJob;

    @Scheduled(cron = "*/30 * * * * ?")
    public void runBatchJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .addString("uniqueId", String.valueOf(System.nanoTime()))
                    .toJobParameters();
            jobLauncher.run(saveKidsPersonalityJob, jobParameters);
            System.out.println("Batch job started successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Scheduled(cron = "*/10 * * * * *")
    public void runDeleteJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(deleteBatchJob, jobParameters);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
