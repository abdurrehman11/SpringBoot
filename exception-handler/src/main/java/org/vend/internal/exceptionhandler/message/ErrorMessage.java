package org.vend.internal.exceptionhandler.message;

import org.vend.internal.exceptionhandler.errortype.ApiErrorType;

import java.text.MessageFormat;

public interface ErrorMessage {

    static String getErrorMessage(ApiErrorType apiErrorType, String paramsList) {

        String params[] = paramsList.split("\\|");
        MessageFormat mf = new MessageFormat(apiErrorType.getErrorMessage());
        String errorMessage = mf.format(params);
        return errorMessage;
    }
}
