package com.example.buoi7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest request) {
        return new ErrorResponse(ex.getMessage(), ex.getStatus());
    }
    @ExceptionHandler(InternalException.class)
    public ErrorResponse handlerInternalException(InternalException ex, WebRequest request) {
        return new ErrorResponse(ex.getMessage(), ex.getStatus());
    }
}
