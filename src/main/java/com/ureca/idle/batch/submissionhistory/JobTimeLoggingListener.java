package com.ureca.idle.batch.submissionhistory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobTimeLoggingListener implements JobExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(JobTimeLoggingListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        jobExecution.getExecutionContext().put("startTime", System.currentTimeMillis());
        logger.info("잡 시작: {}", jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        long startTime = jobExecution.getExecutionContext().getLong("startTime");
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        logger.info("잡 완료: {} (소요 시간: {} ms)", jobExecution.getJobInstance().getJobName(), duration);
    }
}
