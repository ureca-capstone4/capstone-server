package com.ureca.idle.idleaiclient.config;

import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.BaseException;
import com.ureca.idle.idleapi.idleoriginapi.common.exception.config.ExceptionType;

public class AiException extends BaseException {
    public AiException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
