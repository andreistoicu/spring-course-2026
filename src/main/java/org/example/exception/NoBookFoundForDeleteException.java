package org.example.exception;

public class NoBookFoundForDeleteException extends RuntimeException {
    public NoBookFoundForDeleteException(String message) {
        super(message);
    }
}
