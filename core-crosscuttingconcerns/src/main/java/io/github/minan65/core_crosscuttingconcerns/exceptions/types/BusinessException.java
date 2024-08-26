package io.github.minan65.core_crosscuttingconcerns.exceptions.types;


public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
