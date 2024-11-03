package ureca.idleaiclient.implementation;


import ureca.idleexception.BaseException;
import ureca.idleexception.ExceptionType;


public class AiException extends BaseException {
    public AiException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
