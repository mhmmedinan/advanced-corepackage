package io.github.minan65.core_crosscuttingconcerns.exceptions.types;


public class InternalServerException extends InternalError {
    public InternalServerException(String message){
        super(message);
    }
}
