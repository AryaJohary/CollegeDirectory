package com.aryajohary.collegedirectory.exception_handling;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class GlobalErrorResponse {

    // i have created this generic error response and will output it
    // instead of traditional bloated error response we get

    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;

    public GlobalErrorResponse(){}

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
