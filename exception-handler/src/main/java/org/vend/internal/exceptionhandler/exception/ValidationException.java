package org.vend.internal.exceptionhandler.exception;

import org.springframework.http.HttpStatus;
import org.vend.internal.exceptionhandler.errortype.ApiErrorType;

public class ValidationException extends BaseException {

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType) {
        super(apiErrorType, HttpStatus.BAD_REQUEST);
    }

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType, HttpStatus httpStatus) {
        super(apiErrorType, httpStatus);
    }

//    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType, String message) {
//        super(apiErrorType, message, HttpStatus.BAD_REQUEST);
//    }

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType, String paramsList) {
        super(apiErrorType, paramsList, HttpStatus.BAD_REQUEST);
    }

    public ValidationException(ApiErrorType<? extends Enum<?>> apiErrorType, String message, HttpStatus httpStatus) {
        super(apiErrorType, message, httpStatus);
    }

}
