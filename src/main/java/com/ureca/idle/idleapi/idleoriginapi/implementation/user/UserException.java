package com.ureca.idle.idleapi.idleoriginapi.implementation.user;

import com.ureca.idle.idleexception.BaseException;
import com.ureca.idle.idleexception.ExceptionType;



public class UserException extends BaseException {

    public UserException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
