package com.ureca.idle.idleapi.idlefcfsapi.common;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.ExceptionType;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.Status;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum FirstComeFirstServedExceptionType implements ExceptionType {

    ALREADY_ENTERED(Status.BAD_REQUEST, "이미 이번 이벤트에 응모하셨습니다.");

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