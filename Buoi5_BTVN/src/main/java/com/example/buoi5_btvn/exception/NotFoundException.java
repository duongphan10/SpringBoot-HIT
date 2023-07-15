package com.example.buoi5_btvn.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public NotFoundException(String message) {
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }
    public NotFoundException(String message,HttpStatus httpStatus) {
        this.message = message;
        this.status = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
