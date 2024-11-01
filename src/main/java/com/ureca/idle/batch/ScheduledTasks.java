package com.ureca.idle.batch;

import com.ureca.idle.batch.deletedkidspersonalityhistory.config.DeleteDeletedKidsPersonalityJobConfiguration;
import com.ureca.idle.batch.kidspersonalityhistory.config.SaveKidsPersonalityInHistoryJobConfiguration;
import com.ureca.idle.batch.submissionhistory.config.LoadSubmissionHistoryJobConfiguration;
import lombok.RequiredArgsConstructor;
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
    private final DeleteDeletedKidsPersonalityJobConfiguration deleteDeletedKidsPersonalityJobConfiguration;
    private final SaveKidsPersonalityInHistoryJobConfiguration saveKidsPersonalityInHistoryJobConfiguration;
    private final LoadSubmissionHistoryJobConfiguration loadSubmissionHistoryJobConfiguration;

//        @Scheduled(cron = "*/5 * * * * ?")
    public void runSaveKidsPersonalityInHistoryBatchJob() {
        // 현재의 자녀 성향을 자녀 성향 변화 기록에 저장
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .addString("uniqueId", String.valueOf(System.nanoTime()))
                    .toJobParameters();
            jobLauncher.run(saveKidsPersonalityInHistoryJobConfiguration.saveKidsPersonalityInHistoryJob(), jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void runDeleteDeletedKidsPersonalityBatchJob() {
        // 자녀 성향 삭제 기록을 삭제하는 Job
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .addString("uniqueId", String.valueOf(System.nanoTime()))
                    .toJobParameters();
            jobLauncher.run(deleteDeletedKidsPersonalityJobConfiguration.deleteBatchJob(), jobParameters);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Scheduled(cron = "*/10 * * * * ?")
    public void runUpdateSubmissionHistoryBatchJob() {
            // 현재 차수 응모 데이터를 이전 차수 응모 데이터 테이블로 배치
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .addString("uniqueId", String.valueOf(System.nanoTime()))
                    .toJobParameters();
            jobLauncher.run(loadSubmissionHistoryJobConfiguration.updateSubmissionHistoryJob(), jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
