package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

