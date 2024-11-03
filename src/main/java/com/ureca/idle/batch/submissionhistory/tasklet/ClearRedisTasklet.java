package com.ureca.idle.batch.submissionhistory.tasklet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClearRedisTasklet implements Tasklet {

    private final StringRedisTemplate redisTemplate;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        redisTemplate.delete("FCFS");

        log.info("레디스 데이터가 초기화되었습니다.");
        return RepeatStatus.FINISHED;
    }
}
