package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types;


public class AuthorizationException extends RuntimeException {
    public AuthorizationException(String message) {
        super(message);
    }
}
