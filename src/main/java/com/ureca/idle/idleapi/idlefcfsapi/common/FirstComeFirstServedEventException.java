package com.ureca.idle.idleapi.idlefcfsapi.common;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.BaseException;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.ExceptionType;


public class FirstComeFirstServedEventException extends BaseException {
    public FirstComeFirstServedEventException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
