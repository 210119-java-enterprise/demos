package com.revature.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("Invalid request");
    }

    public InvalidRequestException(String message) {
        super(message);
    }

}
