package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.types;

public class RateLimitExceededException extends Exception {
    public RateLimitExceededException(String message) {
        super(message);
    }
}
