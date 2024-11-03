package com.ureca.idle.batch.submissionhistory.tasklet;

import com.ureca.idle.batch.submissionhistory.TimeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("deleteCurrentSubmissionHistoryTasklet")
@RequiredArgsConstructor
public class DeleteCurrentSubmissionHistoryTasklet implements Tasklet {

    private final JdbcTemplate jdbcTemplate;
    private final TimeUtils timeUtils;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String startTimeStr = timeUtils.getStartTime();
        String endTimeStr = timeUtils.getEndTime();

        String deleteQuery = "DELETE FROM current_round_submission WHERE time_stamp >= ? AND time_stamp <= ?";
        int rowsAffected = jdbcTemplate.update(deleteQuery, startTimeStr, endTimeStr);

        log.info("{}개의 현재 차수 응모 데이터가 삭제되었습니다.", rowsAffected);
        return RepeatStatus.FINISHED;
    }
}