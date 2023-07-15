package com.example.buoi4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ErrorResponse handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex, WebRequest request) {
        System.out.println(ex.getMessage());
        return new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException ex, WebRequest request) {
        System.out.println(ex.getMessage());
        return new ErrorResponse(ex.getMessage(), ex.getStatus());
    }

}