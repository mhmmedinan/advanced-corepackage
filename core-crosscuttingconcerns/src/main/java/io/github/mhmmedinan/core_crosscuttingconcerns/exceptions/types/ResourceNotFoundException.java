package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
