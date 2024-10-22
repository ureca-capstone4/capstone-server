package com.ureca.idle.idleapi.idleoriginapi.common.exception.book;


import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.ExceptionType;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.Status;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum BookExceptionType implements ExceptionType {

    BOOK_NOT_FOUND_EXCEPTION(Status.NOT_FOUND, "해당 Book을 찾을 수 없습니다."),
    BOOK_PREFERENCE_NOT_FOUND_EXCEPTION(Status.NOT_FOUND, "해당 책에 대한 호불호를 찾을 수 없습니다.");


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
