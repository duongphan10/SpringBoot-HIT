package com.example.buoi6.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomHandlerException {
    @ExceptionHandler(NotFoundException.class)
    public ErrorReponse NotFoundExceptionHandler(NotFoundException ex) {
        return new ErrorReponse(ex.getMessage(), ex.getHttpStatus());
    }
    @ExceptionHandler(InternalException.class)
    public ErrorReponse InternalExceptionHandler(InternalException ex) {
        return new ErrorReponse(ex.getMessage(),ex.getStatus());
    }
}
