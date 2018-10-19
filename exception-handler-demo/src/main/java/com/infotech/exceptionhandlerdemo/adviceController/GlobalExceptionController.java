package com.infotech.exceptionhandlerdemo.adviceController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vend.internal.exceptionhandler.errortype.GeneralErrorType;
import org.vend.internal.exceptionhandler.exception.BaseException;
import org.vend.internal.exceptionhandler.response.ErrorResponse;
import org.vend.internal.exceptionhandler.response.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionController {

    @ResponseBody
    @ExceptionHandler({BaseException.class})
    public Response handleValidationException(BaseException ex, HttpServletRequest req, HttpServletResponse res) {
        Response response = new ErrorResponse(ex.getHttpStatus().value(), ex.getErrorMessage(), ex.getErrorCode());
        res.setStatus(ex.getHttpStatus().value());
        return response;
    }

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public Response handleGeneralException(HttpServletRequest req, HttpServletResponse res) {
        Response response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), GeneralErrorType.ERROR_DESCRIPTION.getErrorMessage(), GeneralErrorType.ERROR_DESCRIPTION.getErrorCode());
        res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return response;
    }
}