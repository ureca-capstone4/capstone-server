package com.ureca.idle.idleapi.idleoriginapi.common.exception.kid;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.BaseException;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.ExceptionType;



public class KidException extends BaseException {

    public KidException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}

