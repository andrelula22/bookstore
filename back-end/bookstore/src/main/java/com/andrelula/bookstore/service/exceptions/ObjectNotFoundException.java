package com.andrelula.bookstore.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }
}
