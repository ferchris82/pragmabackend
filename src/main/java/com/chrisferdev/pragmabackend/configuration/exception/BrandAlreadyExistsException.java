package com.chrisferdev.pragmabackend.configuration.exception;

public class BrandAlreadyExistsException extends RuntimeException{
    public BrandAlreadyExistsException(String message){
        super(message);
    }
}
