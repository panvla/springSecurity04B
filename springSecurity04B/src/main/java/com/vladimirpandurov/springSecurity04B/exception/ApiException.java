package com.vladimirpandurov.springSecurity04B.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
