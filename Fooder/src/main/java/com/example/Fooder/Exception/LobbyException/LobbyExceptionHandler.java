package com.example.Fooder.Exception.LobbyException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LobbyExceptionHandler {

    @ExceptionHandler(value={LobbyNotFoundException.class})
    public ResponseEntity<Object> handleLobbyNotFoundException
        (LobbyNotFoundException lobbyNotFoundException)
        {
            LobbyException lobbyException = new LobbyException(
                lobbyNotFoundException.getMessage(),
                lobbyNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(lobbyException,HttpStatus.NOT_FOUND);
        }
    
}
