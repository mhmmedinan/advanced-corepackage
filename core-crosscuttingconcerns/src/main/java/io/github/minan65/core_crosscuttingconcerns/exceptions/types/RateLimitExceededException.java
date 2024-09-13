package io.github.minan65.core_crosscuttingconcerns.exceptions.types;


public class RateLimitExceededException extends RuntimeException {
    public RateLimitExceededException(String message) {
        super(message);
    }
}
