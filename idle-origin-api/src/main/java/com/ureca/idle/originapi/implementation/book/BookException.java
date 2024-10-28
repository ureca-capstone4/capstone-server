package com.ureca.idle.originapi.implementation.book;


import com.ureca.idle.exception.BaseException;
import com.ureca.idle.exception.ExceptionType;

public class BookException extends BaseException {

    public BookException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
