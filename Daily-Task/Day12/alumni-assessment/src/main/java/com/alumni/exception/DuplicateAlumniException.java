package com.alumni.exception;

public class DuplicateAlumniException extends RuntimeException {

    public DuplicateAlumniException(String message) {
        super(message);
    }
}