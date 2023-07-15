package com.example.buoi7.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InternalException extends RuntimeException{
    private String message;
    private HttpStatus status;
    public InternalException(String message) {
        this.message = message;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
