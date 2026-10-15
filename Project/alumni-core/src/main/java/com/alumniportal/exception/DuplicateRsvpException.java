package com.alumniportal.exception;


public class DuplicateRsvpException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicateRsvpException() {
        super("Registration failed: You have already registered for this event.");
    }

    public DuplicateRsvpException(String message) {
        super(message);
    }

    public DuplicateRsvpException(String message, Throwable cause) {
        super(message, cause);
    }
}
