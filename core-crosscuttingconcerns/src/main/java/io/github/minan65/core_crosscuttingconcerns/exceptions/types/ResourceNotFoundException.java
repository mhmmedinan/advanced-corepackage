package io.github.minan65.core_crosscuttingconcerns.exceptions.types;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
