package com.ureca.idle.idleapi.idleoriginapi.implementation.book;


import com.ureca.idle.idleexception.ExceptionType;
import com.ureca.idle.idleexception.Status;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum BookExceptionType implements ExceptionType {

    BOOK_NOT_FOUND_EXCEPTION(Status.NOT_FOUND, "해당 책을 찾을 수 없습니다."),
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
