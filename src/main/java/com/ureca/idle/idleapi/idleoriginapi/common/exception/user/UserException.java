package com.ureca.idle.idleapi.idleoriginapi.common.exception.user;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.BaseException;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.ExceptionType;



public class UserException extends BaseException {

    public UserException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
