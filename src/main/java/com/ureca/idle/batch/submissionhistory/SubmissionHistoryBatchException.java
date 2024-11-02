package com.ureca.idle.batch.submissionhistory;

import com.ureca.idle.exception.BaseException;
import com.ureca.idle.exception.ExceptionType;

public class SubmissionHistoryBatchException extends BaseException {

    public SubmissionHistoryBatchException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}