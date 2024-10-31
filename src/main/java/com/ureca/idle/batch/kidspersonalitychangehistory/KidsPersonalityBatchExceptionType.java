package com.ureca.idle.batch.kidspersonalitychangehistory;

import com.ureca.idle.exception.ExceptionType;
import com.ureca.idle.exception.Status;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum KidsPersonalityBatchExceptionType implements ExceptionType {

    KID_NOT_FOUND_EXCEPTION(Status.NOT_FOUND, "아직 성향 검사가 이루어지지 않았습니다."),
    KIDS_PERSONALITY_HISTORY_NOT_SAVE_EXCEPTION_TYPE(Status.BAD_REQUEST, "자녀 성향 히스토리 저장에 실패했습니다.");

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
