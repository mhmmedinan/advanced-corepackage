package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }
}
