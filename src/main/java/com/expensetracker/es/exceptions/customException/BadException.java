package com.expensetracker.es.exceptions.customException;

public class BadException extends RuntimeException{
    public BadException(String message){
        super(message);
    }
}
