package com.revature.exceptions;

public class InvalidAccountException extends RuntimeException{


    public InvalidAccountException(String message){
        super(message);
    }
}
