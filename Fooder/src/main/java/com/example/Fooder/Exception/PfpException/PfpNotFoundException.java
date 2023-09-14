package com.example.Fooder.Exception.PfpException;

public class PfpNotFoundException extends RuntimeException{
    public PfpNotFoundException(String message){
        super(message);
    }
     public PfpNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    
}
