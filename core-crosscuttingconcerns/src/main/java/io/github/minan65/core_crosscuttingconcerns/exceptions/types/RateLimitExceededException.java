package io.github.minan65.core_crosscuttingconcerns.exceptions.types;


public class RateLimitExceededException extends Exception {
    public RateLimitExceededException(String message) {
        super(message);
    }
}
