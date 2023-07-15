package com.example.buoi4.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    private String message;

    private HttpStatus status;

    public NotFoundException(String message) {
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public NotFoundException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

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