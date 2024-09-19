package com.aryajohary.collegedirectory.exception_handling;

public class CustomEntityNotFoundException extends RuntimeException{

    // i have defined this exception to be used as to avoid foreign key violations
    // while defining schemas like StudentProfile, FacultyProfile & AdministratorProfile

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
