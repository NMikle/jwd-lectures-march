package com.epam.jwd.lectures.exception;

public class CatNotReadyException extends RuntimeException {
    public CatNotReadyException(String message) {
        super(message);
    }
}
