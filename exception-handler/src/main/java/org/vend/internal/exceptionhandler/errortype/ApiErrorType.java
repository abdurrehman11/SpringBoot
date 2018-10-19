package org.vend.internal.exceptionhandler.errortype;

public interface ApiErrorType<E extends Enum<E>> {

    String getErrorMessage();
    Integer getErrorCode();
}
