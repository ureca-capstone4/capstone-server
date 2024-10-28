package com.ureca.idle.originapi.implementation.user;


import com.ureca.idle.exception.BaseException;
import com.ureca.idle.exception.ExceptionType;

public class UserException extends BaseException {

    public UserException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
