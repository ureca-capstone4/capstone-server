package ureca.idlebatch.submissionhistory;

import com.ureca.idle.exception.ExceptionType;
import com.ureca.idle.exception.Status;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SubmissionHistoryBatchExceptionType implements ExceptionType {

    PREVIOUS_SUBMISSION_HISTORY_NOT_SAVE_EXCEPTION_TYPRE(Status.BAD_REQUEST,"이전 차수 응모 데이터 저장에 실패했습니다.");

    private final Status status;
    private final String message;

    @Override
    public Status status() {
        return status;
    }

    @Override
    public String message() {
        return message;
    }
}
