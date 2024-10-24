package com.ureca.idle.idleaiclient.implementation;


import com.ureca.idle.idleexception.BaseException;
import com.ureca.idle.idleexception.ExceptionType;

public class AiException extends BaseException {
    public AiException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
