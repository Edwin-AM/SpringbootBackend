package com.nlxa.java.exceptions;

public class IncompleteDataException extends RuntimeException {

    private String message;

    public IncompleteDataException(String message) {
        this.message = message;
    }

    public IncompleteDataException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public IncompleteDataException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public IncompleteDataException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "[-] IncompleteDataException\n" +
                "message = '" + this.message + '\'';
    }
}
