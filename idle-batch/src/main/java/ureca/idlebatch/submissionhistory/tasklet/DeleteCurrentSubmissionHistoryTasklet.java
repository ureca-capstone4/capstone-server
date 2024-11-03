package ureca.idlebatch.submissionhistory.tasklet;

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

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        jdbcTemplate.execute("TRUNCATE TABLE current_round_submission");
        log.info("현재 차수 응모 데이터가 전부 삭제되었습니다.");
        return RepeatStatus.FINISHED;
    }
}