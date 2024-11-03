package ureca.idleaiclient.implementation;


import com.ureca.idle.exception.BaseException;
import com.ureca.idle.exception.ExceptionType;

public class AiException extends BaseException {
    public AiException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
