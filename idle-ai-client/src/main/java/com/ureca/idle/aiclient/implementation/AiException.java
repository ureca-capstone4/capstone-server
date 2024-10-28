package com.ureca.idle.aiclient.implementation;


import com.ureca.idle.exception.BaseException;
import com.ureca.idle.exception.ExceptionType;

public class AiException extends BaseException {
    public AiException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
