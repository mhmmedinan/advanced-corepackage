package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
