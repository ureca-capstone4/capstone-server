package com.ureca.idle.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job saveKidsPersonalityJob;

    @Autowired
    private Job deleteBatchJob;


    @Scheduled(cron = "*/20 * * * * ?")
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

    @Scheduled(cron = "*/10 * * * * *")
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
