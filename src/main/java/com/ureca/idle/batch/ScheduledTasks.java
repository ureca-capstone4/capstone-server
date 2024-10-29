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

    @Scheduled(cron = "*/10 * * * * ?")
    public void runBatchJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(saveKidsPersonalityJob, jobParameters);
            System.out.println("Batch job started successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
