package com.example.Fooder.Exception.LobbyException;
import org.springframework.http.HttpStatus;


public class LobbyException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus HttpStatus;
    
    public LobbyException(String message, Throwable throwable, org.springframework.http.HttpStatus httpStatus) {
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
