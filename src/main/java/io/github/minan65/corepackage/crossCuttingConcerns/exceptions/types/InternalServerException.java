package io.github.minan65.corepackage.crossCuttingConcerns.exceptions.types;

public class InternalServerException extends InternalError {
    public InternalServerException(String message){
        super(message);
    }
}
