package com.aryajohary.collegedirectory.exception_handling;

public class CustomEntityNotFoundException extends RuntimeException{
    public CustomEntityNotFoundException(String message) {
        super(message);
    }

    public CustomEntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomEntityNotFoundException(Throwable cause) {
        super(cause);
    }
}
