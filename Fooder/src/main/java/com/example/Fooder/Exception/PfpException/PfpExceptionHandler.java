package com.example.Fooder.Exception.PfpException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PfpExceptionHandler {

    @ExceptionHandler(value={PfpNotFoundException.class})
    public ResponseEntity<Object> handleLobbyNotFoundException
        (PfpNotFoundException lobbyNotFoundException)
        {
            PfpException lobbyException = new PfpException(
                lobbyNotFoundException.getMessage(),
                lobbyNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(lobbyException,HttpStatus.NOT_FOUND);
        }
    
}