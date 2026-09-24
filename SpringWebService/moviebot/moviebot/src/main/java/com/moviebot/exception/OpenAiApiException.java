package com.moviebot.exception;

import org.springframework.http.HttpStatusCode;

/**
 * ===== TASK 3 =====
 * Thrown whenever the OpenAI API key is missing/invalid, or OpenAI
 * returns a non-200 HTTP status code. Carries the status code along so
 * the controller can map it to an appropriate HTTP response.
 */
public class OpenAiApiException extends RuntimeException {

    private final HttpStatusCode statusCode;

    public OpenAiApiException(String message, HttpStatusCode statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
