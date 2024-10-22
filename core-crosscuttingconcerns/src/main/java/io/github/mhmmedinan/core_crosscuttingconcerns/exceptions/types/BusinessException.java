package io.github.mhmmedinan.core_crosscuttingconcerns.exceptions.types;


public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
