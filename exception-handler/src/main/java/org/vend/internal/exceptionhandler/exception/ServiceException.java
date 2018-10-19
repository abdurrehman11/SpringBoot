package org.vend.internal.exceptionhandler.exception;

import org.springframework.http.HttpStatus;
import org.vend.internal.exceptionhandler.errortype.ApiErrorType;

public class ServiceException extends BaseException {


    public ServiceException(ApiErrorType apiErrorType, HttpStatus httpStatus) {
        super(apiErrorType, httpStatus);
    }
}
