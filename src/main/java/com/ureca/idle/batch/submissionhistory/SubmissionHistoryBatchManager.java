package com.ureca.idle.batch.submissionhistory;

import com.ureca.idle.jpa.submission.CurrentRoundSubmission;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubmissionHistoryBatchManager {

    @Transactional
    public void savePreviousRoundSubmissionHistory(CurrentRoundSubmission currentRoundSubmission, StringBuilder values) {
        try {
            values.append("(")
                    .append("'").append(currentRoundSubmission.getUserId()).append("', ")
                    .append("'").append(currentRoundSubmission.getName()).append("', ")
                    .append("'").append(currentRoundSubmission.getPhoneNum()).append("'), ");
        } catch (Exception e) {
            throw new SubmissionHistoryBatchException(
                    SubmissionHistoryBatchExceptionType.PREVIOUS_SUBMISSION_HISTORY_NOT_SAVE_EXCEPTION_TYPRE);
        }
    }
}