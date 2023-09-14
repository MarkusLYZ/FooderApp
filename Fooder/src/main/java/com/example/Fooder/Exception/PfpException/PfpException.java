package com.example.Fooder.Exception.PfpException;

import org.springframework.http.HttpStatus;

public class PfpException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus HttpStatus;
    
    public PfpException(String message, Throwable throwable, org.springframework.http.HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        HttpStatus = httpStatus;
    }
    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus;
    }
}
