package com.example.buoi5_btvn.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException ex, WebRequest request) {
        System.out.println(ex.getMessage());
        return new ErrorResponse(ex.getMessage(), ex.getStatus());
    }
    @ExceptionHandler(InternalException.class)
    public ErrorResponse handleInternalException(InternalException ex, WebRequest request) {
        System.out.println(ex.getMessage());
        return new ErrorResponse(ex.getMessage(),ex.getStatus());
    }
}
