package io.github.minan65.core_crosscuttingconcerns.exceptions.types;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

