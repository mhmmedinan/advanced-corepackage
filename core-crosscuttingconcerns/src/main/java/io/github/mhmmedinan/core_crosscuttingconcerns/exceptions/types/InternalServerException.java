package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types;


public class InternalServerException extends InternalError {
    public InternalServerException(String message){
        super(message);
    }
}
