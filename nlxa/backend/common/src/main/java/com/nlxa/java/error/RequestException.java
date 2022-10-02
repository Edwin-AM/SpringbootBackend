package com.nlxa.java.error;

import lombok.Data;

@Data
public class RequestException extends RuntimeException {

    private String techMessage;

    public RequestException(String message, String techMessage) {
        super(message);
        this.techMessage = techMessage;
    }

    public RequestException(String message, String techMessage,
                            Throwable exception) {
        super(message, exception);
        this.techMessage = techMessage;
    }
}
