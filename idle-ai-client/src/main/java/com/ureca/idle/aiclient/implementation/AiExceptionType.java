package com.ureca.idle.aiclient.implementation;


import com.ureca.idle.exception.ExceptionType;
import com.ureca.idle.exception.Status;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AiExceptionType implements ExceptionType {

    AI_RESPONSE_NOT_PROPER(Status.SERVER_ERROR, "AI 응답의 형식이 올바르지 않습니다.");

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
