package com.alumniportal.exception;
public class EventCapacityExceededException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EventCapacityExceededException() {
        super("Registration failed: Event has reached its maximum capacity.");
    }

    public EventCapacityExceededException(String message) {
        super(message);
    }

    public EventCapacityExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
