package com.alumniportal.exception;

public class AlumniNotVerifiedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlumniNotVerifiedException() {
        super("Action failed: Alumni account must be verified by an administrator to perform this action.");
    }

    public AlumniNotVerifiedException(String message) {
        super(message);
    }

    public AlumniNotVerifiedException(String message, Throwable cause) {
        super(message, cause);
    }
}
